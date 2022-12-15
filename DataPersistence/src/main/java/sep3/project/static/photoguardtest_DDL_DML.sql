DROP SCHEMA IF EXISTS photoguardtest CASCADE;
CREATE SCHEMA photoguardtest;
SET SCHEMA 'photoguardtest';

CREATE DOMAIN username AS varchar(100) NOT NULL;
CREATE DOMAIN password AS varchar(100) NOT NULL;
CREATE DOMAIN email AS varchar CHECK ( value LIKE '%@%');

CREATE TABLE IF NOT EXISTS Location
(
	id           SERIAL NOT NULL PRIMARY KEY,
	address         varchar (100),
	postCode        varchar (10),
	country         varchar (100),
	town            varchar (100),
	latitude        DECIMAL(14, 10),
	longitude       DECIMAL(14, 10)

);

CREATE TABLE IF NOT EXISTS "User"
(
	id           SERIAL NOT NULL PRIMARY KEY,
	user_name    username,
	first_name   varchar(50),
	last_name    varchar(100),
	password     password,
	email        email,
	phone_number VARCHAR(15),
	location_id int NOT NULL,

	FOREIGN KEY (location_id) REFERENCES location(id)
);

CREATE TABLE IF NOT EXISTS Post
(
	id          serial        NOT NULL PRIMARY KEY,
	user_id     int,
	image_url   varchar(400),
	title       varchar(150)  NOT NULL,
	description varchar(5000) NOT NULL,
	posted_on   timestamp     NOT NULL DEFAULT CURRENT_TIMESTAMP,
	location_id int NOT NULL,
	FOREIGN KEY (user_id) REFERENCES "User" (id),
	FOREIGN KEY (location_id) REFERENCES location(id)
);

CREATE TABLE IF NOT EXISTS Tag_list
(
	tag_name VARCHAR(50) NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Post_tag
(
	post_id  INT         NOT NULL,
	tag_name VARCHAR(50) NOT NULL,
	PRIMARY KEY (post_id, tag_name),
	FOREIGN KEY (post_id) REFERENCES Post (id),
	FOREIGN KEY (tag_name) REFERENCES Tag_list (tag_name)
);

CREATE TABLE IF NOT EXISTS LikePost
(
	user_id INT NOT NULL,
	post_id INT NOT NULL,
	PRIMARY KEY (user_id, post_id),
	FOREIGN KEY (user_id) REFERENCES "User" (id),
	FOREIGN KEY (post_id) REFERENCES Post (id)
);

CREATE TABLE IF NOT EXISTS Comment
(
	id              serial          NOT NULL PRIMARY KEY,
	body            varchar(5000),
	created_on      timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP,
	user_id         int NOT NULL,
	post_id         int NOT NULL,
	FOREIGN KEY (user_id) REFERENCES "User" (id),
	FOREIGN KEY (post_id) REFERENCES Post (id)
);

CREATE TABLE IF NOT EXISTS CommentParentComment
(
	comment_id          INT NOT NULL ,
	parent_comment_id   INT NOT NULL ,
	PRIMARY KEY (comment_id, parent_comment_id) ,
	FOREIGN KEY (comment_id) REFERENCES Comment (id),
	FOREIGN KEY (parent_comment_id) REFERENCES Comment (id)
);

CREATE TABLE IF NOT EXISTS Report
(
	id              serial        NOT NULL PRIMARY KEY,
	violation_desc  varchar(5000),
	post_id         int NOT NULL,
	user_id         int NOT NULL,
	FOREIGN KEY (post_id) REFERENCES Post(id),
	FOREIGN KEY (user_id) REFERENCES "User"(id)
);


CREATE TABLE IF NOT EXISTS Admin
(
	user_name   username UNIQUE PRIMARY KEY,
	password    password,
	email       email
);

CREATE TABLE IF NOT EXISTS Ban_user
(
	id              serial        NOT NULL PRIMARY KEY,
	reason          varchar(5000),
	admin           username,
	user_id         int,
	FOREIGN KEY (admin) REFERENCES Admin(user_name),
	FOREIGN KEY (user_id) REFERENCES "User" (id)
);

CREATE TABLE IF NOT EXISTS Ban_post
(
	id              serial        NOT NULL PRIMARY KEY,
	reason          varchar(5000),
	admin           username,
	post_id         int,
	FOREIGN KEY (admin) REFERENCES Admin(user_name),
	FOREIGN KEY (post_id) REFERENCES Post (id)
);

set schema 'photoguardtest';

INSERT INTO location (address, postcode, country, town, latitude, longitude)
VALUES ('Kemp St10', 6022, 'NZ', 'Wellington', -41.3154278274, 174.7962668968);

INSERT INTO "User" (user_name, first_name, last_name, password, email, phone_number, location_id)
VALUES ('Mira','Mirko','Mirkovic','123','miro123@gmail.com','+4576456789', 1);
INSERT INTO "User" (user_name, first_name, last_name, password, email, phone_number, location_id)
VALUES ('Dara','Darko','Goluza','123','darkogoluza@gmail.com','+4554325623', 1);

INSERT INTO Post (user_id, image_url, title, description, location_id)
VALUES (1,'https://images.unsplash.com/photo-1655574080225-9400f4e6d1ef?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1740&q=80', 'Trash on the beach in New Zealand', 'Today while I was running in the beautiful nature in New Zealand, I have stumbled upon this trash. I believe that we should do something about it. To let people know that this behavior is not ok.', 1);

INSERT INTO tag_list (tag_name)
VALUES ('Polution');

INSERT INTO post_Tag (post_id, tag_name)
VALUES (1, 'Polution');

INSERT INTO tag_list (tag_name)
VALUES ('beach');

INSERT INTO post_Tag (post_id, tag_name)
VALUES (1, 'beach');

INSERT INTO LikePost (user_id, post_id)
VALUES (2, 1);

INSERT INTO LikePost (user_id, post_id)
VALUES (1, 1);


INSERT INTO comment (body, user_id, post_id)
VALUES ('That is awful!', 2, 1);

INSERT INTO comment (body, user_id, post_id)
VALUES ('Let''s do something about it', 2, 1);

INSERT INTO comment (body, user_id, post_id)
VALUES ('Let''s contact town hall about that', 1, 1);

INSERT INTO CommentParentComment (comment_id, parent_comment_id)
VALUES (3, 2);


INSERT INTO report(violation_desc, post_id, user_id)
VALUES ('The image is not related to the topic', 1, 1);

INSERT INTO admin (user_name, password, email)
VALUES ('admin', 'admin123', 'admin@gmail.com');

drop TRIGGER if exists whenbanpostchanges on ban_post;
DROP FUNCTION if EXISTS insertIntoBanUserId();
create FUNCTION insertIntoBanUserId()
	RETURNS trigger
	LANGUAGE plpgsql
AS $$
DECLARE userId int;
	DECLARE count int;
BEGIN
	SELECT user_id
	INTO userId
	FROM post
	WHERE post.id = new.post_id;

	select count(*)
	into count
	from ban_post
	where post_id in (SELECT id from post where user_id = userId);

	if count >= 3
	then
		Insert Into ban_user(reason, admin, user_id)
		VALUES('more than 3 reported posts', new.admin, userId);
	end if;

	return new;
END
$$;

CREATE TRIGGER whenBanPostChanges
	AFTER INSERT
	on "ban_post"
	for EACH ROW
--     when
EXECUTE PROCEDURE insertIntoBanUserId();
