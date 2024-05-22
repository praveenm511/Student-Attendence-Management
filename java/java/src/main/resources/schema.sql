CREATE TABLE IF NOT EXISTS Student (
    name VARCHAR(100) NOT NULL,
    rollNo INT PRIMARY KEY,
    address VARCHAR(255),
    department ENUM('Computer Science', 'Mechanical Engineering', 'Electrical Engineering', 'Biology', 'Mathematics', 'Physics', 'Chemistry') NOT NULL
);