DROP TABLE IF EXISTS ers_user_roles;
DROP TABLE IF EXISTS ers_users;
DROP TABLE IF EXISTS ers_reimbursement_type;
DROP TABLE IF EXISTS ers_reimbursement_status;
DROP TABLE IF EXISTS ers_reimbursement;

CREATE TABLE ers_user_roles(
    ers_user_role_id SERIAL PRIMARY KEY,
    user_role VARCHAR(30)
);


CREATE TABLE ers_users(
    ers_users_id SERIAL PRIMARY KEY,
    ers_username VARCHAR(50) UNIQUE,
    ers_password VARCHAR(50),
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
    reimb_reciept BYTEA,
    reimb_author INTEGER REFERENCES ers_users(ers_users_id),
    reimb_resolver INTEGER REFERENCES ers_users(ers_users_id),
    reimb_status_id INTEGER,
    reimb_type_id INTEGER
);



ALTER TABLE ers_reimbursement ADD FOREIGN KEY(reimb_author) REFERENCES ers_users(ers_users_id);