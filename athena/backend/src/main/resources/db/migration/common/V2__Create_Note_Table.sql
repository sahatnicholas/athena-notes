create TABLE IF NOT EXISTS "note"
(
    id CHAR(36) PRIMARY KEY,
    created_by VARCHAR(80) NOT NULL,
    created_date TIMESTAMP WITH TIME ZONE NOT NULL,
    last_modified_by VARCHAR(80) NOT NULL,
    last_modified_date TIMESTAMP WITH TIME ZONE NOT NULL,
    user_id CHAR(36) NOT NULL,
    title VARCHAR(80),
    body TEXT,
    archived BOOLEAN NOT NULL DEFAULT FALSE
);
