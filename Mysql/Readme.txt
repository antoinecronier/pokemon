connect to mysql with root user without password
do :
	\>mysql -u root
	-> CREATE DATABASE pokemon
	-> exit
	\>mysql -u root pokemon < PathToProject/Mysql/bddpokemon.sql