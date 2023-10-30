CREATE TABLE supplier (  
    id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT 'Primary Key',
    create_time DATETIME COMMENT 'Create Time',
    name VARCHAR(255) COMMENT 'supplier name',
    address VARCHAR(500) COMMENT 'supplier address',
    tell VARCHAR(100)
) COMMENT '';