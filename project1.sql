DROP TABLE IF EXISTS ers_user_roles CASCADE;
DROP TABLE IF EXISTS ers_users CASCADE;
DROP TABLE IF EXISTS ers_reimbursement_type CASCADE;
DROP TABLE IF EXISTS ers_reimbursement_status CASCADE;
DROP TABLE IF EXISTS ers_reimbursement CASCADE;

CREATE TABLE ers_user_roles(
    ers_user_role_id SERIAL PRIMARY KEY,
    user_role VARCHAR(30)
);


CREATE TABLE ers_users(
    ers_user_id SERIAL PRIMARY KEY,
    ers_username VARCHAR(50) UNIQUE,
    ers_password VARCHAR(500),
    user_first_name VARCHAR(100),
    user_last_name VARCHAR(100),
    user_email VARCHAR(150) UNIQUE,
    user_role_id INTEGER REFERENCES ers_user_roles(ers_user_role_id)
);

CREATE TABLE ers_reimbursement_type(
    reimb__type_id SERIAL PRIMARY KEY,
    reimb_type VARCHAR(10)
    );

CREATE TABLE ers_reimbursement_status(
    reimb_status_id SERIAL PRIMARY KEY,
    reimb_status VARCHAR(10)
);


CREATE TABLE ers_reimbursement(
    reimb_id SERIAL PRIMARY KEY,
    reimb_amount NUMERIC,
    reimb_submitted TIMESTAMP,
    reimb_resolved TIMESTAMP,
    reimb_description VARCHAR(250),
    reimb_receipt BYTEA,
    reimb_author INTEGER REFERENCES ers_users(ers_user_id),
    reimb_resolver INTEGER REFERENCES ers_users(ers_user_id),
    reimb_status_id INTEGER,
    reimb_type_id INTEGER
);


INSERT INTO ers_user_roles(user_role) VALUES('approver');
INSERT INTO ers_user_roles(user_role) VALUES('author');

INSERT INTO ers_reimbursement_status (reimb_status) VALUES ('pending');
INSERT INTO ers_reimbursement_status (reimb_status) VALUES ('approved');
INSERT INTO ers_reimbursement_status (reimb_status) VALUES ('denied');

UPDATE ers_users SET user_role_id = 4 WHERE ers_username = 'admin';

UPDATE ers_user_roles SET user_role = 'BASE' WHERE ers_user_role_id = 1;
UPDATE ers_user_roles SET user_role = 'CUSTOMER' WHERE ers_user_role_id = 2;
INSERT INTO ers_user_roles(user_role) VALUES('EMPLOYEE');
INSERT INTO ers_user_roles(user_role) VALUES('MANAGER');

INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES('admin', 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86', 'Matt', 'Smith', 'matt.smith@aol.com', 2);
INSERT INTO ers_users(ers_username, ers_password,user_first_name, user_last_name, user_email, user_role_id)
VALUES('admin2', 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86','David', 'Tennant', 'david.tennant@outlook.com', '4');