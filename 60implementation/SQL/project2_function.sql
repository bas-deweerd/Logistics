
BEGIN WORK;
CREATE OR REPLACE FUNCTION addNewUser (newUsername varchar(30), newPassword varchar(15),newUsertpe int)
RETURNS BOOLEAN AS $$
BEGIN
	IF newUsername in(
		SELECT username FROM users
		)
		THEN
		RAISE EXCEPTION 'Username already exists please pick a unique one.';
	RETURN FALSE;

	ELSE
	insert into users(username,password,usertype) values(newUsername, newPassword, newUsertpe);
	return true;
	end if;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION addNewTruck (newBrand varchar(30), newModel varchar(15),newBuildYear int, newLicenseplate varchar(15),newTowing_cap int)
RETURNS BOOLEAN AS $$
BEGIN
	IF newLicenseplate in(
		SELECT licenseplate FROM truck
		)
		THEN
		RAISE EXCEPTION 'Truck with this licenseplate already exists please pick a unique one.';
	RETURN FALSE;

	ELSE
	insert into truck(brand,model,buildyear,licenseplate,towing_cap) values(newBrand, newModel, newBuildYear,newLicenseplate,newTowing_cap);
	return true;
	end if;
END;
$$ LANGUAGE plpgsql;
commit;
BEGIN WORK;
CREATE OR REPLACE FUNCTION addNewTrailer (newLicenseplate varchar(15),newLoading_cap decimal)
RETURNS BOOLEAN AS $$
BEGIN
	IF newLicenseplate in(
		SELECT licenseplate FROM trailer
		)
		THEN
		RAISE EXCEPTION 'Trailer with this licenseplate already exists please pick a unique one.';
	RETURN FALSE;

	ELSE
	insert into trailer(licenseplate,loading_cap) values(newLicenseplate,newLoading_cap);
	return true;
	end if;
END;
$$ LANGUAGE plpgsql;
commit;
BEGIN WORK;
CREATE OR REPLACE FUNCTION addNewCustomer (newName varchar(30),newPhonenr varChar(30),newEmail varchar(50),newlocation int)
RETURNS BOOLEAN AS $$
BEGIN
	IF newName in(
		SELECT name FROM customer
		)
		THEN
		RAISE EXCEPTION 'Customer already exists.';
	RETURN FALSE;

	ELSE
	insert into customer(name,phone_nr,email,location_nr) values(newName,newPhonenr,newEmail,newlocation);
	return true;
	end if;
END;
$$ LANGUAGE plpgsql;
commit;
BEGIN WORK;
CREATE OR REPLACE FUNCTION addNewLocation (newName varchar(30),newadress varChar(30),newCity varchar(50),newCountry varChar(50))
RETURNS BOOLEAN AS $$
BEGIN
	IF newName IN(
	SELECT company_name FROM location) AND newadress IN(
	SELECT adress FROM location) AND newCity IN(
	SELECT city FROM location)
	THEN
	RAISE EXCEPTION 'Location already exists';
	RETURN FALSE;
	ELSE
	INSERT INTO location(company_name,adress,city,country) VALUES(newName,newadress,newCity,newCountry);
	RETURN TRUE;
	END IF;
END;
$$ LANGUAGE plpgsql;
commit;


/*
select addNewLocation('bier','venlo','city','nederland');
select * from location

*/

BEGIN WORK;
CREATE OR REPLACE FUNCTION addNewOrder (newCustomer varchar(50),newProduct varChar(50),newAmount int)
RETURNS BOOLEAN AS $$
BEGIN
	insert into orders(customer,product,amount) values(newCustomer,newProduct,newAmount);
	return true;

END;
$$ LANGUAGE plpgsql;
commit;