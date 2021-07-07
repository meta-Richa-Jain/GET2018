#Question4

# Create appropriate tables and relationships for the same and write a SQL
# query for that returns a Resultset containing Zip Code, City Names and
# States ordered by State Name and City Name.

SELECT z.pin_code, z.area, z.city, z.state 
FROM zip_code z
ORDER BY z.state, z.city;