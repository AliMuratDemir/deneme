package ApiTest.Pet;

import com.consol.citrus.actions.AbstractTestAction;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.sql.SQLException;

import static help.regex.jsonFormatter;
import static help.regex.reg;

public class PetTest extends PetEndPointTest {

    @Test
    @CitrusTest
    public void GetPetid() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "12");
                // String name ="GetPetid";
                String name="PostPet";

                String url = "/pet/";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("pet",200,url,name);

                System.out.println("******** "+name+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name+"REQ"));

                System.out.println("******** "+name+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name+"RES"));

                String res =(context.getMessageStore().getMessage(""+name+"RES")).toString();
                String response=reg(responsePatternId,res);
                String statuscode=reg(httpStatusCodePattern,res);

                jsonFormatter("[{"+response+"}]");

                int id= JsonPath.read("[{"+response+"}]","$[0]['id']");
                String Name = JsonPath.read("[{"+response+"}]","$[0]['tags'].[0]['name']");

                System.out.println("id:"+id);
                System.out.println("Name:"+Name);
                System.out.println("statuscode:"+statuscode);

                String name2="GetPetid";
                String url2 = "/pet/"+id+"";

                System.out.println("****************************************** "+name2+" ***************************************************");


                getMethod(name2,url2,200);

                System.out.println("******** "+name2+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"REQ"));

                System.out.println("******** "+name2+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"RES"));

                String res2 =(context.getMessageStore().getMessage(""+name2+"RES")).toString();
                String response2=reg(responsePatternId,res2);
                String statuscode2=reg(httpStatusCodePattern,res2);

                jsonFormatter("[{"+response2+"}]");

                Integer Id= JsonPath.read("[{"+response2+"}]","$[0]['id']");
                String Name2 = JsonPath.read("[{"+response2+"}]","$[0]['tags'].[0]['name']");

                System.out.println("Id:"+Id);
                System.out.println("Name2:"+Name2);

                System.out.println("statuscode2:"+statuscode2);
                if( Name2.equals("") ||!statuscode2.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetPetidHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";

                // String name ="GetPetid";
                String name="GetPetid";
                String Id= "88156000000";

                String url = "/pet/"+Id+"";


                System.out.println("****************************************** "+name+" ***************************************************");
                getMethod(name,url,404);

                System.out.println("******** "+name+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name+"REQ"));

                System.out.println("******** "+name+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name+"RES"));

                String res =(context.getMessageStore().getMessage(""+name+"RES")).toString();
                String response=reg(responsePatternId,res);
                String statuscode=reg(httpStatusCodePattern,res);

                jsonFormatter("[{"+response+"}]");

                //Double id= JsonPath.read("[{"+response+"}]","$[0]['id']");
                String type = JsonPath.read("[{"+response+"}]","$[0]['type']");
                String message = JsonPath.read("[{"+response+"}]","$[0]['message']");

                System.out.println("message:"+message);
                System.out.println("type:"+type);

                System.out.println("statuscode:"+statuscode);
                if( !message.equals("Pet not found")|| !type.equals("error") ||!statuscode.equals("404"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 404 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetPetfindByStatus() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\[\\{(.*?)\\}\\]\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";

                String name2="GetPetfindByStatus";
                String url2 = "/pet/findByStatus?status=available";

                System.out.println("****************************************** "+name2+" ***************************************************");


                getMethod(name2,url2,200);

                System.out.println("******** "+name2+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"REQ"));

                System.out.println("******** "+name2+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"RES"));

                String res2 =(context.getMessageStore().getMessage(""+name2+"RES")).toString();
                String response2=reg(responsePatternId,res2);
                String statuscode2=reg(httpStatusCodePattern,res2);

                jsonFormatter("[{"+response2+"}]");

                Long Id= JsonPath.read("[{"+response2+"}]","$[0]['id']");
                String Name2 = JsonPath.read("[{"+response2+"}]","$[0]['category'].['name']");

                System.out.println("Id:"+Id);
                System.out.println("Name2:"+Name2);

                System.out.println("statuscode2:"+statuscode2);
                if( Name2.equals("") ||!statuscode2.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetPetfindByStatusHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";

                String name2="GetPetfindByStatus";
                String url2 = "/pet/findByStatuss";

                System.out.println("****************************************** "+name2+" ***************************************************");


                getMethod(name2,url2,404);

                System.out.println("******** "+name2+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"REQ"));

                System.out.println("******** "+name2+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"RES"));

                String res2 =(context.getMessageStore().getMessage(""+name2+"RES")).toString();
                String response2=reg(responsePatternId,res2);
                String statuscode2=reg(httpStatusCodePattern,res2);

                jsonFormatter("[{"+response2+"}]");

                System.out.println("statuscode2:"+statuscode2);
                if(!statuscode2.equals("404"))
                {
                    throw new NullPointerException("status 404 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void PostPet() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "12");
                // String name ="GetPetid";
                String name="PostPet";

                String url = "/pet/";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("pet",200,url,name);

                System.out.println("******** "+name+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name+"REQ"));

                System.out.println("******** "+name+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name+"RES"));

                String res =(context.getMessageStore().getMessage(""+name+"RES")).toString();
                String response=reg(responsePatternId,res);
                String statuscode=reg(httpStatusCodePattern,res);

                jsonFormatter("[{"+response+"}]");

                int id= JsonPath.read("[{"+response+"}]","$[0]['id']");
                String Name = JsonPath.read("[{"+response+"}]","$[0]['tags'].[0]['name']");

                System.out.println("id:"+id);
                System.out.println("Name:"+Name);

                System.out.println("statuscode:"+statuscode);
                if( Name.equals("") ||!statuscode.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void PostPetHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "aa");
                // String name ="GetPetid";
                String name="PostPet";

                String url = "/pet/";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("pet",500,url,name);

                System.out.println("******** "+name+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name+"REQ"));

                System.out.println("******** "+name+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name+"RES"));

                String res =(context.getMessageStore().getMessage(""+name+"RES")).toString();
                String response=reg(responsePatternId,res);
                String statuscode=reg(httpStatusCodePattern,res);

                jsonFormatter("[{"+response+"}]");

                //Double id= JsonPath.read("[{"+response+"}]","$[0]['id']");
                int code = JsonPath.read("[{"+response+"}]","$[0]['code']");
                String message = JsonPath.read("[{"+response+"}]","$[0]['message']");

                System.out.println("message:"+message);
                System.out.println("code:"+code);

                System.out.println("statuscode:"+statuscode);
                if( !message.equals("something bad happened") || code!=500 ||!statuscode.equals("500"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 500 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void PutPet() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "0");
                context.setVariable("categoryname", "dogs");
                context.setVariable("tagsname", "deneme");
                context.setVariable("status", "available");
                // String name ="GetPetid";
                String name="PutPet";

                String url = "/pet/";


                System.out.println("****************************************** "+name+" ***************************************************");
                putMethod("putpet",200,url,name);

                System.out.println("******** "+name+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name+"REQ"));

                System.out.println("******** "+name+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name+"RES"));

                String res =(context.getMessageStore().getMessage(""+name+"RES")).toString();
                String response=reg(responsePatternId,res);
                String statuscode=reg(httpStatusCodePattern,res);

                jsonFormatter("[{"+response+"}]");

                //Double id= JsonPath.read("[{"+response+"}]","$[0]['id']");
                String Name = JsonPath.read("[{"+response+"}]","$[0]['tags'].[0]['name']");

                //System.out.println("id:"+id);
                System.out.println("Name:"+Name);

                System.out.println("statuscode:"+statuscode);
                if( Name.equals("") ||!statuscode.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void PutPetHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "aa");
                context.setVariable("categoryname", "dogs");
                context.setVariable("tagsname", "deneme");
                context.setVariable("status", "available");
                // String name ="GetPetid";
                String name="PutPet";

                String url = "/pet/";


                System.out.println("****************************************** "+name+" ***************************************************");
                putMethod("putpet",500,url,name);

                System.out.println("******** "+name+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name+"REQ"));

                System.out.println("******** "+name+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name+"RES"));

                String res =(context.getMessageStore().getMessage(""+name+"RES")).toString();
                String response=reg(responsePatternId,res);
                String statuscode=reg(httpStatusCodePattern,res);

                jsonFormatter("[{"+response+"}]");

                //Double id= JsonPath.read("[{"+response+"}]","$[0]['id']");
                int code = JsonPath.read("[{"+response+"}]","$[0]['code']");
                String message = JsonPath.read("[{"+response+"}]","$[0]['message']");

                System.out.println("message:"+message);
                System.out.println("code:"+code);

                System.out.println("statuscode:"+statuscode);
                if( !message.equals("something bad happened") || code!=500 ||!statuscode.equals("500"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 500 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void DeletePet() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "11");
                // String name ="GetPetid";
                String name="PostPet";

                String url = "/pet/";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("pet",200,url,name);

                System.out.println("******** "+name+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name+"REQ"));

                System.out.println("******** "+name+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name+"RES"));

                String res =(context.getMessageStore().getMessage(""+name+"RES")).toString();
                String response=reg(responsePatternId,res);
                String statuscode=reg(httpStatusCodePattern,res);

                jsonFormatter("[{"+response+"}]");

                Integer id= JsonPath.read("[{"+response+"}]","$[0]['id']");
                String Name = JsonPath.read("[{"+response+"}]","$[0]['tags'].[0]['name']");

                System.out.println("id:"+id);
                System.out.println("Name:"+Name);

                System.out.println("statuscode:"+statuscode);

                String name2="DeletePet";
                String url2="/pet/"+id+"";

                System.out.println("****************************************** "+name2+" ***************************************************");

                deleteMethod(name2,url2,200);

                System.out.println("******** "+name2+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"REQ"));

                System.out.println("******** "+name2+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"RES"));

                String res2 =(context.getMessageStore().getMessage(""+name2+"RES")).toString();
                String response2=reg(responsePatternId,res2);
                String statuscode2=reg(httpStatusCodePattern,res2);

                jsonFormatter("[{"+response2+"}]");

                Integer code = JsonPath.read("[{"+response2+"}]","$[0]['code']");
                String message = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code:"+code);
                System.out.println("message:"+message);

                System.out.println("statuscode:"+statuscode2);


                if( !statuscode2.equals("200") || code!=200 )
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void DeletePetHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";

                int id=11;
                String name2="DeletePet";
                String url2="/pet/"+id+"";

                System.out.println("****************************************** "+name2+" ***************************************************");

                deleteMethod(name2,url2,404);

                System.out.println("******** "+name2+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"REQ"));

                System.out.println("******** "+name2+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"RES"));

                String res2 =(context.getMessageStore().getMessage(""+name2+"RES")).toString();
                String response2=reg(responsePatternId,res2);
                String statuscode2=reg(httpStatusCodePattern,res2);

                jsonFormatter("[{"+response2+"}]");

                System.out.println("statuscode:"+statuscode2);


                if( !statuscode2.equals("404") )
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }
}
