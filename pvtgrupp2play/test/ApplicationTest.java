import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 3;
        assertThat(a).isEqualTo(4);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("Your new application is ready.");
    }
    @Test
    public void testBetyg() {
        controllers.Produkt p = new controllers.Produkt();
        p.setBetyg("4");
        assertThat(p.getBetyg()).isEqualTo(4);
        
    }
    @Test
    public void testBetygTecken() {
        controllers.Produkt p = new controllers.Produkt();
        p.setBetyg("....");
        assertThat(p.getBetyg()).isEqualTo(0);
    }
    @Test
    public void testBetygNull() {
        controllers.Produkt p = new controllers.Produkt();
        p.setBetyg(null);
        assertThat(p.getBetyg()).isEqualTo(0);
    }
    @Test
    public void testBetygTom() {
        controllers.Produkt p = new controllers.Produkt();
        p.setBetyg("");
        assertThat(p.getBetyg()).isEqualTo(0);
    }
    @Test
    public void testBetygLitet() {
        controllers.Produkt p = new controllers.Produkt();
        p.setBetyg("-1");
        assertThat(p.getBetyg()).isEqualTo(0);
    }
    @Test
    public void testBetygStort() {
        controllers.Produkt p = new controllers.Produkt();
        p.setBetyg("10");
        assertThat(p.getBetyg()).isEqualTo(0);
    }
    @Test
    public void testUID(){
        boolean test = Validator.validateUid("100000");
        assertThat(test).isEqualTo(true);
    }
    @Test
    public void testUIDtext(){
        boolean test = Validator.validateUid("hej");
        assertThat(test).isEqualTo(false);
    }    
    @Test
    public void testUIDnull(){
        boolean test = Validator.validateUid(null);
        assertThat(test).isEqualTo(false);
    }
  
  
    
    
    /**@Test
    public void fbtest(){
        String token = "CAALXCpBEB4sBAMtdilX14Sgcx7MRoujAHZCLwe9eTGqlFTRrZADDmWhD20na5ZBABSZB19LZBZBitEvs8FYHqXq2KhiqsbhzLdIVOrO7vryceJlsWdnewg94YZBdMjsglrmQIGGSZBGT0hPZAezrNdTUl4oS3HxiWT46GIQMLiY4DZBo0MEKWs21ErZA8521ZAT10ZAZC1wErbxy5ssEgwXIWacwqW";
        boolean test = FBvalidator.validateFb(token);
        assertTrue("ehh?",test);
    }**/


}
