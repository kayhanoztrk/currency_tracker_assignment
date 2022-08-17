INSERT INTO user (id,username,password) VALUES (1,'user','user')
INSERT INTO user (id,username,password) VALUES (2,'admin','admin')
INSERT INTO role (role_id,role_name) VALUES (1,'ROLE_USER')
INSERT INTO role (role_id,role_name) VALUES (2,'ROLE_ADMIN')
INSERT INTO user_role (user_id,role_id) VALUES (1,1),(2,2)

INSERT INTO currency (id,name,symbol,current_price,created_time,enabled) VALUES (1,'Bitcoin','BTC','20000','2022-09-10',true)
INSERT INTO alert (id,currency_id,target_price,status,created_at) VALUES (1,1,'30000','NEW','2022-09-10')