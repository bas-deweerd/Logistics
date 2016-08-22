SELECT addNewUser('richard van den ham','planning',5);
SELECT addNewUser('thijs dorsers','ceo',2);
SELECT addNewUser('ferd van odenhoven','wololo',1);
SELECT addNewUser('geert meneer','ordersislove',4);
SELECT addNewUser('bob beton','engrish',3);
SELECT addNewTruck('DAF','XF',2007,'aa-b1-c2',20);
SELECT addNewTrailer('aa-b1-c2',17);
SELECT addNewCustomer('Sander Bronsmo','0773548552','s.bronsmo@fontys.nl',1);
SELECT addNewOrder('Geert Wilders','Aldi Cola',10);
delete FROM customer where name = 'Sander Bronsmo';
SELECT * FROM location
ORDER BY id
