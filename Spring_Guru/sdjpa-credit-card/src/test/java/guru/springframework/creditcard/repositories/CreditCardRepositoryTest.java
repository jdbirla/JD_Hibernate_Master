package guru.springframework.creditcard.repositories;

import guru.springframework.creditcard.service.EncryptionService;
import guru.springframework.creditcard.domain.CreditCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jd birla on 26-04-2023 at 06:50
 */
@SpringBootTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CreditCardRepositoryTest {

    final String CREDIT_CARD = "12345678900000";

    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    EncryptionService encryptionService;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    void testSaveAndStoreCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setCreditCardNumber(CREDIT_CARD);
        creditCard.setCvv("123");
        creditCard.setExpirationDate("12/2028");

        CreditCard savedCC = creditCardRepository.saveAndFlush(creditCard);

        System.out.println("Getting CC from database: " + savedCC.getCreditCardNumber());

        System.out.println("CC At Rest");
        System.out.println("CC Encrypted: " + encryptionService.encrypt(CREDIT_CARD));

        Map<String, Object> dbRow = jdbcTemplate.queryForMap("SELECT * FROM credit_card " +
                "WHERE id = " + savedCC.getId());

        String dbCardValue = (String) dbRow.get("credit_card_number");

        assertThat(savedCC.getCreditCardNumber()).isNotEqualTo(dbCardValue);
        assertThat(dbCardValue).isEqualTo(encryptionService.encrypt(CREDIT_CARD));

        CreditCard fetchedCC = creditCardRepository.findById(savedCC.getId()).get();

        assertThat(savedCC.getCreditCardNumber()).isEqualTo(fetchedCC.getCreditCardNumber());

    }


}