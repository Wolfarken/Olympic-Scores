create database Athletics_AV2
go
use Athletics_AV2



select * from Country order by coi, name_Country
select * from Athlete order by coi, name_athlete, gender_athlete
select * from Sport order by measurementType_sport, name_sport, gender_sport
select * from WorldRecord
select * from PhaseResult



--Prova
drop table Country
go
create table Country
(
coi char(3) not null,
name_Country varchar(200),
primary key (coi)
)



--Atleta
drop table Athlete
go
create table Athlete
(
code_athlete int not null,
coi char(3) not null,
name_athlete varchar(200),
gender_athlete char(1),
primary key (code_athlete, coi),
foreign key (coi) references Country(coi)
)
insert into Athlete values
(1,'ANG','Aragorn Elessar','M'),
(2,'BIZ','Galadriel Lady of Light','F'),
(3,'AFG','Eowyn Of Rohan','F'),
(4,'BRA','Gandalf The Grey','M'),
(5,'CZE','Barbora Spot�kov�','F'),
(6,'USA','Mike Powell','M'),
(7,'FRA','Renaud Lavillenie','M'),
(8,'RUS','Natalya Lisovskaya','F'),
(9,'GER','Jurgen Schult','M'),
(10,'UKR','Inessa Kravets','F'),
(11,'USA','Florence Griffith-Joyner','F'),
(12,'JAM','Usain Bolt','M'),
(13,'RSA','Wayde van Niekerk','M'),
(14,'USA','Kevin Young','M'),
(15,'SVK','Jarmila Kratochvilova','F'),
(16,'KEN','David Rudisha','M'),
(17,'KEN','Daniel Komen','M'),
(18,'KEN','Beatrice Chepkoech','F')


--Prova
drop table Sport
go
create table Sport
(
id_sport int not null,
name_sport varchar(200),
gender_sport char(1),
measurementType_sport varchar(30)
primary key (id_sport)
)
insert into Sport values
(1,'Javalin Throw','F','Metric'),
(2,'Long Jump','M','Metric'),
(3,'Pole Vault','M','Metric'),
(4,'Shot Put','F','Metric'),
(5,'Discus Throw','M','Metric'),
(6,'Triple Jump','F','Metric'),
(7,'100 m','F','Time'),
(8,'100 m','M','Time'),
(9,'200 m','F','Time'),
(10,'200 m','M','Time'),
(11,'400 m','M','Time'),
(12,'400 m Hurdles','M','Time'),
(13,'800 m','F','Time'),
(14,'800 m','M','Time'),
(15,'3000 m','M','Time'),
(16,'3000 m Steeplechase','F','Time')


--Recordes Mundial
drop table WorldRecord
go
create table WorldRecord
(
id_sport int not null,
code_athlete int not null,
coi char(3) not null,
world_recordDecimal decimal(4,2),
world_recordTime time,
primary key (id_sport, code_athlete, coi),
foreign key (id_sport) references Sport (id_sport),
foreign key (code_athlete, coi) references Athlete(code_athlete, coi)
)
insert into WorldRecord values
(1,		5,	'CZE',	72.28,	null),
(2,		6,	'USA',	8.95,	null),
(3,		7,	'FRA',	6.16,	null),
(4,		8,	'RUS',	22.63,	null),
(5,		9,	'GER',	74.08,	null),
(6,		10, 'UKR',	15.50,	null),
(7,		11, 'USA',	null,	'00:00:10.49000'),
(8,		12, 'JAM',	null,	'00:00:09.58000'),
(9,		11, 'USA',	null,	'00:00:21.34000'),
(10,	12, 'JAM',	null,	'00:00:19.19000'),
(11,	13, 'RSA',	null,	'00:00:43.03000'),
(12,	14, 'USA',	null,	'00:00:46.78000'),
(13,	15, 'SVK',	null,	'00:01:53.28000'),
(14,	16, 'KEN',	null,	'00:01:40.91000'),
(15,	17, 'KEN',	null,	'00:07:20.67000'),
(16,	18, 'KEN',	null,	'00:08:44.32000')
select * from WorldRecord



--Recordes Olimpiadas
drop table OlympicRecord
go
create table OlympicRecord
(
id_sport int not null,
code_athlete int not null,
coi char(3) not null,
olympic_recordDecimal decimal(4,2),
olympic_recordTime time,
primary key (id_sport, code_athlete, coi),
foreign key (id_sport) references Sport (id_sport),
foreign key (code_athlete, coi) references Athlete(code_athlete, coi)
)
select * from OlympicRecord
insert into OlympicRecord values
(1,		1, 'ANG',	0.0,	null),
(2,		1, 'ANG',	0.0,	null),
(3,		1, 'ANG',	0.0,	null),
(4,		1, 'ANG',	0.0,	null),
(5,		1, 'ANG',	0.0,	null),
(6,		1, 'ANG',	0.0,	null),
(7,		1, 'ANG',	null,	'23:59:59.99999'),
(8,		1, 'ANG',	null,	'23:59:59.99999'),
(9,		1, 'ANG',	null,	'23:59:59.99999'),
(10,	1, 'ANG',	null,	'23:59:59.99999'),
(11,	1, 'ANG',	null,	'23:59:59.99999'),
(12,	1, 'ANG',	null,	'23:59:59.99999'),
(13,	1, 'ANG',	null,	'23:59:59.99999'),
(14,	1, 'ANG',	null,	'23:59:59.99999'),
(15,	1, 'ANG',	null,	'23:59:59.99999'),
(16,	1, 'ANG',	null,	'23:59:59.99999')




--Bateria Fase
drop table PhaseResult
go
create table PhaseResult
(
id_sport int not null,
code_athlete int not null,
coi char(3) not null,
phase varchar(15),		--	Initial , Final
primary key (id_sport, code_athlete, coi, phase),
foreign key (id_sport) references Sport(id_sport),
foreign key (code_athlete, coi) references Athlete(code_athlete, coi)
)
select * from PhaseResult
insert into PhaseResult values
(5,1,'ANG','Initial'),
(5,4,'BRA','Initial'),
(5,6,'USA','Initial'),
(5,7,'FRA','Initial'),
(5,9,'GER','Initial'),
(5,12,'JAM','Initial'),
(5,13,'RSA','Initial'),
(5,14,'USA','Initial'),
(5,16,'KEN','Initial'),
(5,17,'KEN','Initial')



--Resultado
drop table Result
go
create table Result
(
id_sport int not null,
code_athlete int not null,
coi char(3) not null,
phase varchar(15),		--	Initial , Final
trial_round int,
resultTime time,
resultDecimal decimal(4,2),
chanceToFinish int,		--	Calculates the chance to finish the test
primary key (id_sport, code_athlete, coi, phase, trial_round),
foreign key (id_sport) references Sport(id_sport),
foreign key (code_athlete, coi) references Athlete(code_athlete, coi)
)
select * from Result
delete from PhaseResult where phase = 'Final'





declare @exit varchar(max)
exec SP_Olympic 2, 1, 'asd', @exit output
print @exit


drop procedure SP_Olympic
go
create procedure SP_Olympic(@id_sport int, @code_athlete int, @coi char(3),
							@exit varchar(max) OUTPUT)
as
	if ((select gender_sport from Sport where id_sport = @id_sport) = (select gender_athlete from Athlete where code_athlete = @code_athlete))
	begin
		insert into PhaseResult values
		(@id_sport, @code_athlete, @coi, 'Initial')
		set @exit = 'Athlete registered successfully'
	end
	else
	begin
		raiserror ('Genders of the Athlete and Sport are different',16,1)
	end






declare @exit varchar(max)
exec SP_InitialPhase 2, 'Initial', @exit output
print @exit

select * from Result
exec SP_ShowResult 2, 'Initial'

drop procedure SP_InitialPhase
go
create procedure SP_InitialPhase(@id_sport int, @phase varchar(15),
									@exit varchar(max) OUTPUT)
as
	declare @code_athlete int,
			@coi char(3),
			@trial_round int,
			@resultTime time,
			@resultDecimal decimal(4,2),
			@chanceToFinish int

	if ((select measurementType_sport from Sport where id_sport = @id_sport) = 'Time')
	begin
		declare resultTime_cursor cursor for
		select distinct code_athlete From PhaseResult where id_sport = @id_sport and phase = @phase

		open resultTime_cursor
		fetch next from resultTime_cursor into @code_athlete

		while @@FETCH_STATUS = 0
		begin
			set @coi = (select coi from Athlete where code_athlete = @code_athlete)
			set @resultTime = (select DATEADD(MILLISECOND, cast(1800000 * RAND() as int), CONVERT(time, '00:00')))
			set @chanceToFinish = (select cast(100 * RAND() as int))

			if (@resultTime < (select world_recordTime from WorldRecord where id_sport = @id_sport and @chanceToFinish > 19))
			begin
				update	WorldRecord
						set code_athlete = @code_athlete, coi = @coi, world_recordTime = @resultTime 
						where id_sport = @id_sport
			end

			if (@resultTime < (select olympic_recordTime from OlympicRecord where id_sport = @id_sport and @chanceToFinish > 19))
			begin
				update	OlympicRecord
						set code_athlete = @code_athlete, coi = @coi, olympic_recordTime = @resultTime
						where id_sport = @id_sport
			end

			insert into Result values
			(@id_sport, @code_athlete, @coi, @phase, '1', @resultTime, null, @chanceToFinish)

			fetch next from resultTime_cursor into @code_athlete
		end

		close resultTime_cursor
		deallocate resultTime_cursor
	end
	else if ((select measurementType_sport from Sport where id_sport = @id_sport) = 'Metric')
	begin
		declare resultMetric_cursor cursor for
		select distinct code_athlete From PhaseResult where id_sport = @id_sport and phase = @phase

		open resultMetric_cursor
		fetch next from resultMetric_cursor into @code_athlete

		while @@FETCH_STATUS = 0
		begin
			set @coi = (select coi from Athlete where code_athlete = @code_athlete)
			set @trial_round = 1
			
			while (@trial_round < 7)
			begin
				set @resultDecimal = (select cast(99 * RAND() as decimal(4,2)))
				set @chanceToFinish = (select cast(100 * RAND() as int))

				if (@resultDecimal > (select world_recordDecimal from WorldRecord where id_sport = @id_sport and @chanceToFinish > 19))
				begin
					update	WorldRecord
							set code_athlete = @code_athlete, coi = @coi, world_recordDecimal = @resultDecimal
							where id_sport = @id_sport
				end

				if (@resultDecimal > (select olympic_recordDecimal from OlympicRecord where id_sport = @id_sport and @chanceToFinish > 19))
				begin
					update	OlympicRecord
							set code_athlete = @code_athlete, coi = @coi, olympic_recordDecimal = @resultDecimal
							where id_sport = @id_sport
				end

				insert into Result values
				(@id_sport, @code_athlete, @coi, @phase, @trial_round, null, @resultDecimal, @chanceToFinish)

				set @trial_round = @trial_round + 1
			end

			fetch next from resultMetric_cursor into @code_athlete
		end

		close resultMetric_cursor
		deallocate resultMetric_cursor
	end
	else
	begin
		raiserror ('The Initial test have alredy been done',16,1)
	end






exec SP_EndPhase 5

drop procedure SP_EndPhase
go
create procedure SP_EndPhase(@id_sport int)
as
	if ((select measurementType_sport from Sport where id_sport = @id_sport) = 'Time')
	begin
		insert into PhaseResult (id_sport, code_athlete, coi, phase)
		select top 8 id_sport, code_athlete, coi, 'Final' from FN_ResultTime(@id_sport)
		where id_sport = @id_sport
		order by chanceToFinish desc, result asc
	end
	else if ((select measurementType_sport from Sport where id_sport = @id_sport) = 'Metric')
	begin
		insert into PhaseResult (id_sport, code_athlete, coi, phase)
		select top 8 id_sport, code_athlete, coi, 'Final'
		from 
		(
		select *,
		RowNumber = ROW_NUMBER() over (partition by id_sport, code_athlete, coi, phase order by chanceToFinish desc, result desc)
		from FN_ResultMetric(@id_sport)
		) s
		where id_sport = @id_sport and RowNumber = 1
		order by chanceToFinish desc, result desc
	end


	



exec SP_ShowResult 1, 'Initial'

drop procedure SP_ShowResult
go
create procedure SP_ShowResult(@id_sport int, @phase varchar(15))
as
	if ((select measurementType_sport from Sport where id_sport = @id_sport) = 'Time')
	begin
		select * from FN_ResultTime(@id_sport)
		where id_sport = @id_sport and phase = @phase
		order by chanceToFinish desc, result asc
	end
	else if ((select measurementType_sport from Sport where id_sport = @id_sport) = 'Metric')
	begin
		select * 
		from 
		(
		select *,
		RowNumber = ROW_NUMBER() over (partition by id_sport, code_athlete, coi, phase order by chanceToFinish desc, result desc)
		from FN_ResultMetric(@id_sport)
		) s
		where id_sport = @id_sport and phase = @phase and RowNumber = 1
		order by chanceToFinish desc, result desc
	end






select * from FN_ResultTime(7)
where id_sport = 7 and phase = 'Initial'
order by chanceToFinish desc, result asc

drop function FN_ResultTime
go
create function FN_ResultTime(@id_sport int)
returns @table Table
(
id_sport int,
code_athlete int,
coi char(3),
phase varchar(15),
trial_round int,
result time,
chanceToFinish varchar(10)
)
as
begin
	insert @table(id_sport, code_athlete, coi, phase, trial_round, result, chanceToFinish)
	select id_sport, code_athlete, coi, phase, trial_round, resultTime, chanceToFinish from Result
	begin
		update	@table
				set chanceToFinish = 'FINISH'
				where chanceToFinish > '19'

		update	@table
				set chanceToFinish = 'DNF'
				where chanceToFinish < '20'
	end
	return
end



(5,'Discus Throw','M','Metric'),
(1,'Javalin Throw','F','Metric'),
(2,'Long Jump','M','Metric'),
(3,'Pole Vault','M','Metric'),
delete from Result where phase = 'Final'
select * from PhaseResult


delete From Result
delete from PhaseResult



select * from Result
where id_sport = 5
order by resultDecimal desc



select * 
from 
(
select *,
RowNumber = ROW_NUMBER() over (partition by id_sport, code_athlete, coi, phase order by chanceToFinish desc, result desc)
from FN_ResultMetric(5)
) s
where id_sport = 5 and phase = 'Initial' and RowNumber = 1
order by chanceToFinish desc, result desc



drop function FN_ResultMetric
go
create function FN_ResultMetric(@id_sport int)
returns @table Table
(
id_sport int,
code_athlete int,
coi char(3),
phase varchar(15),
trial_round int,
result decimal(4,2),
chanceToFinish varchar(10)
)
as
begin
	insert @table(id_sport, code_athlete, coi, phase, trial_round, result, chanceToFinish)
	select id_sport, code_athlete, coi, phase, trial_round, resultDecimal, chanceToFinish from Result
	begin
		update	@table
		set chanceToFinish = 'FINISH'
		where chanceToFinish > '19'

		update	@table
		set chanceToFinish = 'FAULT'
		where chanceToFinish < '20'
	end
	return
end
















--Triggers Country
drop trigger t_DontUpdateCountry
go
create trigger t_DontUpdateCountry
on Country
after update
as
begin
	rollback transaction
	raiserror('Not possible to update data from this table',16,1)
end


drop trigger t_DontDeleteCountry
go
create trigger t_DontDeleteCountry
on Country
after delete
as
begin
	rollback transaction
	raiserror('Not possible to delete data from this table',16,1)
end



--Triggers Athlete
drop trigger t_DontUpdateAthlete
go
create trigger t_DontUpdateAthlete
on Athlete
after update
as
begin
	rollback transaction
	raiserror('Not possible to update data from this table',16,1)
end


drop trigger t_DontDeleteAthlete
go
create trigger t_DontDeleteAthlete
on Athlete
after delete
as
begin
	rollback transaction
	raiserror('Not possible to delete data from this table',16,1)
end



--Triggers PhaseResult
drop trigger t_DontUpdateResult
go
create trigger t_DontUpdateResult
on PhaseResult
after update
as
begin
	rollback transaction
	raiserror('Not possible to update data from this table',16,1)
end


drop trigger t_DontDeleteResult
go
create trigger t_DontDeleteResult
on PhaseResult
after delete
as
begin
	rollback transaction
	raiserror('Not possible to delete data from this table',16,1)
end



--Triggers Result
drop trigger t_DontUpdateResult
go
create trigger t_DontUpdateResult
on Result
after update
as
begin
	rollback transaction
	raiserror('Not possible to update data from this table',16,1)
end


drop trigger t_DontDeleteResult
go
create trigger t_DontDeleteResult
on Result
after delete
as
begin
	rollback transaction
	raiserror('Not possible to delete data from this table',16,1)
end










/**
drop function FN_ResultTime
go
create function FN_ResultTime(@rand time)
returns time
as
begin
	return (@rand)
end
**/





/**
insert into Sport values
(1,'Javalin Throw','F'),
(2,'Long Jump','M'),
(3,'Pole Vault','M'),
(4,'Shot Put','F'),
(5,'Discus Throw','M'),
(6,'Triple Jump','F'),
(7,'100 m','F'),
(8,'100 m','M'),
(9,'200 m','F'),
(10,'200 m','M'),
(11,'400 m','M'),
(12,'400 m Hurdles','M'),
(13,'800 m','F'),
(14,'800 m','M'),
(15,'3000 m','M'),
(16,'3000 m Steeplechase','F')


insert into Country values
('AFG',	'Afeganist�o'),
('ALB',	'Alb�nia'),
('ALG',	'Arg�lia'),
('AND',	'Andorra'),
('ANG',	'Angola'),
('ANT',	'Ant�gua e Barbuda'),
('ASA',	'Samoa Americana'),
('ARG',	'Argentina'),
('ARM',	'Arm�nia'),
('ARU',	'Aruba'),
('AUS',	'Austr�lia'),
('AUT',	'�ustria'),
('AZE',	'Azerbaij�o'),
('BAH',	'Bahamas'),
('BAN',	'Bangladesh'),
('BAR',	'Barbados'),
('BDI',	'Burundi'),
('BEL',	'B�lgica'),
('BEN',	'Benim'),
('BER',	'Bermudas'),
('BHU',	'But�o'),
('BIH',	'B�snia e Herzegovina'),
('BIZ',	'Belize'),
('BLR',	'Bielorr�ssia'),
('BOL',	'Bol�via'),
('BOT',	'Botswana'),
('BRA',	'Brasil'),
('BRN',	'Bahrein'),
('BRU',	'Brunei'),
('BUL',	'Bulg�ria'),
('BUR',	'Burkina Faso'),
('CAF',	'Rep�blica Centro-Africana'),
('CAM',	'Camboja'),
('CAN',	'Canad�'),
('CAY',	'Ilhas Cayman'),
('CGO',	'Rep�blica do Congo'),
('CHA',	'Chade'),
('CHI',	'Chile'),
('CHN',	'China designa��o do�COI: Rep�blica Popular da China'),
('CIV',	'Costa do Marfim'),
('CMR',	'Camar�es'),
('COD',	'Rep�blica Democr�tica do Congo'),
('COK',	'Ilhas Cook'),
('COL',	'Col�mbia'),
('COM',	'Comores'),
('CPV',	'Cabo Verde'),
('CRC',	'Costa Rica'),
('CRO',	'Cro�cia'),
('CUB',	'Cuba'),
('CYP',	'Chipre'),
('CZE',	'Rep�blica Checa'),
('DEN',	'Dinamarca'),
('DJI',	'Djibouti'),
('DMA',	'Dominica'),
('DOM',	'Rep�blica Dominicana'),
('ECU',	'Equador'),
('EGY',	'Egito'),
('ERI',	'Eritreia'),
('ESA',	'El Salvador'),
('ESP',	'Espanha'),
('EST',	'Est�nia'),
('ETH',	'Eti�pia'),
('FIJ',	'Fiji'),
('FIN',	'Finl�ndia'),
('FRA',	'Fran�a'),
('FSM',	'Estados Federados da Micron�sia'),
('GAB',	'Gab�o'),
('GAM',	'G�mbia'),
('GBR',	'Reino Unido designa��o do�COI: Gr�-Bretanha'),
('GBS',	'Guin�-Bissau'),
('GEO',	'Ge�rgia'),
('GEQ',	'Guin� Equatorial'),
('GER',	'Alemanha'),
('GHA',	'Gana'),
('GRE',	'Gr�cia'),
('GRN',	'Granada'),
('GUA',	'Guatemala'),
('GUI',	'Guin�'),
('GUM',	'Guam'),
('GUY',	'Guiana'),
('HAI',	'Haiti'),
('HKG',	'Hong Kong designa��o do�COI: Hong Kong, China'),
('HON',	'Honduras'),
('HUN',	'Hungria'),
('INA',	'Indon�sia'),
('IND',	'�ndia'),
('IRI',	'Ir�o designa��o do�COI: Rep�blica Isl�mica do Ir�o'),
('IRL',	'Irlanda'),
('IRQ',	'Iraque'),
('ISL',	'Isl�ndia'),
('ISR',	'Israel'),
('ISV',	'Ilhas Virgens Americanas'),
('ITA',	'It�lia'),
('IVB',	'Ilhas Virgens Brit�nicas'),
('JAM',	'Jamaica'),
('JOR',	'Jord�nia'),
('JPN',	'Jap�o'),
('KAZ',	'Cazaquist�o'),
('KEN',	'Qu�nia'),
('KGZ',	'Quirguist�o'),
('KIR',	'Kiribati'),
('KOR',	'Coreia do Sul designa��o do�COI: Rep�blica da Coreia'),
('KOS',	'Kosovo'),
('KSA',	'Ar�bia Saudita'),
('KUW',	'Kuwait'),
('LAO',	'Laos designa��o do�COI: Rep�blica Democr�tica Popular do Laos'),
('LAT',	'Let�nia'),
('LBA',	'L�bia'),
('LBR',	'Lib�ria'),
('LCA',	'Santa L�cia'),
('LES',	'Lesoto'),
('LBN',	'L�bano'),
('LIE',	'Liechtenstein'),
('LTU',	'Litu�nia'),
('LUX',	'Luxemburgo'),
('MAD',	'Madag�scar'),
('MAR',	'Marrocos'),
('MAS',	'Mal�sia'),
('MAW',	'Malawi'),
('MDA',	'Mold�via designa��o do�COI: Rep�blica de Moldova'),
('MDV',	'Maldivas'),
('MEX',	'M�xico'),
('MGL',	'Mong�lia'),
('MHL',	'Ilhas Marshall'),
('MKD',	'Maced�nia do Norte'),
('MLI',	'Mali'),
('MLT',	'Malta'),
('MNE',	'Montenegro'),
('MON',	'M�naco'),
('MOZ',	'Mo�ambique'),
('MRI',	'Maur�cia'),
('MTN',	'Maurit�nia'),
('MYA',	'Mianmar'),
('NAM',	'Nam�bia'),
('NCA',	'Nicar�gua'),
('NED',	'Pa�ses Baixos'),
('NEP',	'Nepal'),
('NGR',	'Nig�ria'),
('NIG',	'N�ger'),
('NOR',	'Noruega'),
('NRU',	'Nauru'),
('NZL',	'Nova Zel�ndia'),
('OMA',	'Om�'),
('PAK',	'Paquist�o'),
('PAN',	'Panam�'),
('PAR',	'Paraguai'),
('PER',	'Peru'),
('PHI',	'Filipinas'),
('PLE',	'Palestina'),
('PLW',	'Palau'),
('PNG',	'Papua-Nova Guin�'),
('POL',	'Pol�nia'),
('POR',	'Portugal'),
('PRK',	'Coreia do Norte'),
('PUR',	'Porto Rico'),
('QAT',	'Catar'),
('ROU',	'Rom�nia'),
('RSA',	'�frica do Sul'),
('RUS',	'R�ssia designa��o do�COI: Federa��o Russa'),
('RWA',	'Ruanda'),
('SAM',	'Samoa'),
('SEN',	'Senegal'),
('SEY',	'Seicheles'),
('SGP',	'Singapura'),
('SKN',	'S�o Crist�v�o e N�vis'),
('SLE',	'Serra Leoa'),
('SLO',	'Eslov�nia'),
('SMR',	'San Marino'),
('SOL',	'Ilhas Salom�o'),
('SOM',	'Som�lia'),
('SRB',	'S�rvia'),
('SRI',	'Sri Lanka'),
('SSD',	'Sud�o do Sul'),
('STP',	'S�o Tom� e Pr�ncipe'),
('SUD',	'Sud�o'),
('SUI',	'Su��a'),
('SUR',	'Suriname'),
('SVK',	'Eslov�quia'),
('SWE',	'Su�cia'),
('SWZ',	'Suazil�ndia'),
('SYR',	'S�ria'),
('TAN',	'Tanz�nia'),
('TGA',	'Tonga'),
('THA',	'Tail�ndia'),
('TJK',	'Tajiquist�o'),
('TKM',	'Turquemenist�o'),
('TLS',	'Timor-Leste'),
('TOG',	'Togo'),
('TPE',	'(Taiwan) designa��o do�COI: Taip� Chin�s'),
('TTO',	'Trinidad e Tobago'),
('TUN',	'Tun�sia'),
('TUR',	'Turquia'),
('TUV',	'Tuvalu'),
('UAE',	'Emirados �rabes'),
('UGA',	'Uganda'),
('UKR',	'Ucr�nia'),
('URU',	'Uruguai'),
('USA',	'Estados Unidos'),
('UZB',	'Uzbequist�o'),
('VAN',	'Vanuatu'),
('VEN',	'Venezuela'),
('VIE',	'Vietn�'),
('VIN',	'S�o Vicente e Granadinas'),
('YEM',	'I�men'),
('ZAM',	'Z�mbia'),
('ZIM',	'Zimbabwe'),
('MIX',	'Equipes internacionais')

**/


/**
insert into PhaseResult values
(1,1,'asd','Initial','00:28:13:125'),
(1,2,'dsa','Initial','00:25:13:125'),
(2,1,'asd','Initial','300 m'),
(2,3,'qwe','Initial','259 m')
**/