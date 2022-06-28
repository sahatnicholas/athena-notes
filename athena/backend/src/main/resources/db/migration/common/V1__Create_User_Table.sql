create TABLE IF NOT EXISTS "user_app"
(
    id CHAR(36) PRIMARY KEY,
    created_by VARCHAR(80) NOT NULL,
    created_date TIMESTAMP WITH TIME ZONE NOT NULL,
    last_modified_by VARCHAR(80) NOT NULL,
    last_modified_date TIMESTAMP WITH TIME ZONE NOT NULL,
    username VARCHAR(80) UNIQUE,
    password VARCHAR(80) NOT NULL
);
