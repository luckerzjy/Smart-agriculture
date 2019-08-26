/*初始化数据*/
INSERT INTO user (id, username, password, name, email) VALUES (1,'lucker','123','lucker_zhang','287164808@qq.com');
INSERT INTO user (id, username, password, name, email) VALUES (1,'zjy','123','laozhang','287164808@qq.com');

INSERT INTO authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);