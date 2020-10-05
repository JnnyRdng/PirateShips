package com.codeclan.example.pirateservice;

import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.models.Raid;
import com.codeclan.example.pirateservice.models.Ship;
import com.codeclan.example.pirateservice.repositories.RaidRepository;
import com.codeclan.example.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.codeclan.example.pirateservice.repositories.PirateRepository;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createShipAndPirate() {
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Raid raid1 = new Raid("Cornwall", 100);
		Raid raid2 = new Raid("Edinburgh", 1000);

		raidRepository.save(raid1);
		raidRepository.save(raid2);

		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
		Pirate jim = new Pirate("Jim", "Harkins", 87, ship);
		Pirate john = new Pirate("John", "Silver", 55, ship);

		jack.addRaid(raid1);
		jim.addRaid(raid1);
		jim.addRaid(raid2);
		john.addRaid(raid1);

		pirateRepository.save(jack);
		pirateRepository.save(jim);
		pirateRepository.save(john);


	}
}
