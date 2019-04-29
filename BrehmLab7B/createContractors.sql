CREATE TABLE Contractors
(
	Id INTEGER PRIMARY KEY,
	CompanyName VARCHAR(30),
	Phone VARCHAR(12),
        ContactName VARCHAR(30),
        Rating INT,
        OutOfStateService BOOLEAN
);

INSERT INTO Contractors 
VALUES (1, 'Tom''s Contractors', '555-555-5555', 'Tom Thumb', 81, true); 
    	
INSERT INTO Contractors 
VALUES (2, 'Greg''s Contractors', '666-666-6666', 'Greg Thumb', 12, true); 

INSERT INTO Contractors 
VALUES (3, 'Phil''s Contractors', '777-777-7777', 'Phil Thumb', 34, false); 

INSERT INTO Contractors 
VALUES (4, 'Thanos''s Contractors', '888-888-8888', 'Thanos Thumb', 92, true); 

INSERT INTO Contractors 
VALUES (5, 'Jeff''s Contractors', '999-999-9999', 'Jeff Thumb', 45, false); 

INSERT INTO Contractors 
VALUES (6, 'Robert''s Contractors', '111-111-1111', 'Robert Thumb', 61, true); 

INSERT INTO Contractors 
VALUES (7, 'Steve''s Contractors', '222-222-2222', 'Steve Thumb', 78, false); 