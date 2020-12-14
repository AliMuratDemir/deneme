package ApiTest.User;

import com.consol.citrus.dsl.junit.JUnit4CitrusTestRunner;
import com.consol.citrus.exceptions.CitrusRuntimeException;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.message.MessageType;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.util.Random;

public class UserEndPointTest extends JUnit4CitrusTestRunner {

    @Autowired
    HttpClient apiClient;

    public void getMethod(String name,String url,int statusCode) {

        try {

            http(action -> action.client(apiClient)
                    .send()
                    .get(url)
                    .name(""+name+"REQ")
                    .messageType(MessageType.JSON)
                    //.header("Authorization","Bearer ${token}")

                    .contentType(ContentType.APPLICATION_JSON.toString())

            );

            http(action -> action.client(apiClient)
                    .receive()
                    .response()
                    .messageType(MessageType.JSON)
                    .name(""+name+"RES")
                    .statusCode(statusCode));
            //.extractFromPayload("$[0]['name']","name"));

            traceVariables();
        } catch (CitrusRuntimeException e) {
            createVariable("hata", "1.ADIM HATALI");

        }

    }

    public void postMethod(String fileName,int  status,String url, String name) {

        try {
            Random rand=new Random();
            int rand_int1 = rand.nextInt(1000000);
            createVariable("rand_int1", Integer.toString(rand_int1));
            http(action -> action.client(apiClient)
                    .send()
                    .post(url)
                    .name(""+name+"REQ")
                    .messageType(MessageType.JSON)
                    //.header("Authorization","Bearer ${token}")
                    .contentType(ContentType.APPLICATION_JSON.toString())
                    .payload(new ClassPathResource("request/Api/POSTREQ/" +fileName+".json"))
            );

            String response= "";
            http(action -> action.client(apiClient)
                    .receive()
                    .response()
                    .messageType(MessageType.JSON)
                    .name(""+name+"RES")
                    .statusCode(status)
            );

            traceVariables();
        } catch (CitrusRuntimeException e) {

            createVariable("hata", "1.ADIM HATALI");

        }

    }

    public void putMethod(String fileName,int  status,String url, String name) {

        try {
            Random rand=new Random();
            int rand_int1 = rand.nextInt(1000000);
            createVariable("rand_int1", Integer.toString(rand_int1));
            http(action -> action.client(apiClient)
                    .send()
                    .put(url)
                    .name(""+name+"REQ")
                    .messageType(MessageType.JSON)
                    //.header("Authorization","Bearer ${token}")
                    .contentType(ContentType.APPLICATION_JSON.toString())
                    .payload(new ClassPathResource("request/Api/POSTREQ/" +fileName+".json"))
            );

            String response= "";
            http(action -> action.client(apiClient)
                    .receive()
                    .response()
                    .messageType(MessageType.JSON)
                    .name(""+name+"RES")
                    .statusCode(status)
            );

            traceVariables();
        } catch (CitrusRuntimeException e) {

            createVariable("hata", "1.ADIM HATALI");

        }

    }

    public void deleteMethod(String name,String url,int statusCode) {

        try {

            http(action -> action.client(apiClient)
                    .send()
                    .delete(url)
                    .name(""+name+"REQ")
                    .messageType(MessageType.JSON)
                    //.header("Authorization","Bearer ${token}")

                    .contentType(ContentType.APPLICATION_JSON.toString())

            );

            http(action -> action.client(apiClient)
                    .receive()
                    .response()
                    .messageType(MessageType.JSON)
                    .name(""+name+"RES")
                    .statusCode(statusCode));
            //.extractFromPayload("$[0]['name']","name"));

            traceVariables();
        } catch (CitrusRuntimeException e) {
            createVariable("hata", "1.ADIM HATALI");

        }

    }
}
