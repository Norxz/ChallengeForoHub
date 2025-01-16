CREATE TABLE course (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        category VARCHAR(255) NOT NULL
);

CREATE TABLE user (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL
);

CREATE TABLE topic (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       message TEXT NOT NULL,
                       creation_date DATETIME NOT NULL,
                       status VARCHAR(255) NOT NULL,
                       author_id BIGINT NOT NULL,
                       course_id BIGINT NOT NULL,
                       FOREIGN KEY (author_id) REFERENCES user (id),
                       FOREIGN KEY (course_id) REFERENCES course (id)
);

CREATE TABLE reply (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       message TEXT NOT NULL,
                       creation_date DATETIME NOT NULL,
                       solution BOOLEAN,
                       author_id BIGINT NOT NULL,
                       topic_id BIGINT NOT NULL,
                       FOREIGN KEY (author_id) REFERENCES user (id),
                       FOREIGN KEY (topic_id) REFERENCES topic (id)
);