USE customerinfo;

-- CREATE A NEW USER
CREATE USER orders_id WITH PASSWORD 'Rahul@123';

-- GRANT PRIVILEGES TO THE NEW USER
GRANT SELECT, INSERT, UPDATE ON orders TO order_id;

-- REVOKE CERTAIN PRIVILEGES FROM THE USER 
REVOKE UPDATE ON orders FROM order_id;
