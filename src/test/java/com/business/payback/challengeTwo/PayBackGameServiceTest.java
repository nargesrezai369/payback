package com.business.payback.challengeTwo;

import com.business.payback.challengeTwo.service.PayBackGameService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author : Nargess
 **/
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PayBackGameServiceTest {

    @Order(1)
    @Test
    public void invalidGameRoundTest(){

        //call services and assertThrows with RuntimeException
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> PayBackGameService.startGame(3));
    }

    @Order(1)
    @Test
    public void validGameRound(){

        //call services successfully
         PayBackGameService.startGame(25);
    }
}
