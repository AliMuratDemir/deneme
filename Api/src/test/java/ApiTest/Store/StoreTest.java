package ApiTest.Store;

import com.consol.citrus.actions.AbstractTestAction;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.sql.SQLException;

import static help.regex.jsonFormatter;
import static help.regex.reg;

public class StoreTest extends StoreEndPointTest{

    @Test
    @CitrusTest
    public void PostStore() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "1");
                context.setVariable("petId", "12");
                context.setVariable("quantity", "0");
                context.setVariable("status", "placed");
                context.setVariable("complete", "true");
                // String name ="GetPetid";
                String name="PostStore";

                String url = "/store/order";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("store",200,url,name);

                System.out.println("******** "+name+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name+"REQ"));

                System.out.println("******** "+name+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name+"RES"));

                String res =(context.getMessageStore().getMessage(""+name+"RES")).toString();
                String response=reg(responsePatternId,res);
                String statuscode=reg(httpStatusCodePattern,res);

                jsonFormatter("[{"+response+"}]");

                int id= JsonPath.read("[{"+response+"}]","$[0]['id']");
                int petId = JsonPath.read("[{"+response+"}]","$[0]['petId']");
                String status = JsonPath.read("[{"+response+"}]","$[0]['status']");

                System.out.println("id:"+id);
                System.out.println("petId:"+petId);
                System.out.println("status:"+status);
                System.out.println("statuscode:"+statuscode);

                if( id==0 || petId==0 || status.equals("") ||!statuscode.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void PostStoreHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "aa");
                context.setVariable("petId", "12");
                context.setVariable("quantity", "0");
                context.setVariable("status", "placed");
                context.setVariable("complete", "true");
                // String name ="GetPetid";
                String name="PostStore";

                String url = "/store/order";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("store",500,url,name);

                System.out.println("******** "+name+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name+"REQ"));

                System.out.println("******** "+name+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name+"RES"));

                String res =(context.getMessageStore().getMessage(""+name+"RES")).toString();
                String response=reg(responsePatternId,res);
                String statuscode=reg(httpStatusCodePattern,res);

                jsonFormatter("[{"+response+"}]");

                int code= JsonPath.read("[{"+response+"}]","$[0]['code']");
                String message = JsonPath.read("[{"+response+"}]","$[0]['message']");

                System.out.println("code:"+code);
                System.out.println("message:"+message);
                System.out.println("statuscode:"+statuscode);

                if( code!=500 || !message.equals("something bad happened") ||!statuscode.equals("500"))
                {
                    throw new NullPointerException(" status 500 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetStore() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "1");
                context.setVariable("petId", "12");
                context.setVariable("quantity", "0");
                context.setVariable("status", "placed");
                context.setVariable("complete", "true");
                // String name ="GetPetid";
                String name="PostStore";

                String url = "/store/order";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("store",200,url,name);

                System.out.println("******** "+name+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name+"REQ"));

                System.out.println("******** "+name+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name+"RES"));

                String res =(context.getMessageStore().getMessage(""+name+"RES")).toString();
                String response=reg(responsePatternId,res);
                String statuscode=reg(httpStatusCodePattern,res);

                jsonFormatter("[{"+response+"}]");

                int id= JsonPath.read("[{"+response+"}]","$[0]['id']");
                int petId = JsonPath.read("[{"+response+"}]","$[0]['petId']");
                String status = JsonPath.read("[{"+response+"}]","$[0]['status']");

                System.out.println("id:"+id);
                System.out.println("petId:"+petId);
                System.out.println("status:"+status);
                System.out.println("statuscode:"+statuscode);

                String name2="GetStore";
                String url2="/store/order/"+id+"";

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

                int id2= JsonPath.read("[{"+response2+"}]","$[0]['id']");
                int petId2 = JsonPath.read("[{"+response2+"}]","$[0]['petId']");
                String status2 = JsonPath.read("[{"+response2+"}]","$[0]['status']");

                System.out.println("id2:"+id2);
                System.out.println("petId2:"+petId2);
                System.out.println("status2:"+status2);
                System.out.println("statuscode2:"+statuscode2);

                if( id2!=id || petId!=petId2 || status2.equals("") ||!statuscode2.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetStoreHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";

                int id= 0;
                String name2="GetStore";
                String url2="/store/order/"+id+"";

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

                int code= JsonPath.read("[{"+response2+"}]","$[0]['code']");
                String message = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code:"+code);
                System.out.println("message:"+message);
                System.out.println("statuscode2:"+statuscode2);

                if( code!=1 || !message.equals("Order not found") ||!statuscode2.equals("404"))
                {
                    throw new NullPointerException(" status 404 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetStoreinventory() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";

                int id= 0;
                String name2="GetStoreinventory";
                String url2="/store/inventory";

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

                int sold= JsonPath.read("[{"+response2+"}]","$[0]['sold']");
                int available = JsonPath.read("[{"+response2+"}]","$[0]['available']");

                System.out.println("sold:"+sold);
                System.out.println("available:"+available);
                System.out.println("statuscode2:"+statuscode2);

                if( sold==0 || available==0 ||!statuscode2.equals("200"))
                {
                    throw new NullPointerException(" status 200 değil yada data null");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetStoreinventoryHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";

                int id= 0;
                String name2="GetStoreinventory";
                String url2="/store/inventoryy";

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

                int code= JsonPath.read("[{"+response2+"}]","$[0]['code']");
                String message = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code:"+code);
                System.out.println("message:"+message);
                System.out.println("statuscode2:"+statuscode2);

                if( code!=404 || !message.equals("null for uri: http://petstore.swagger.io/v2/store/inventoryy") ||!statuscode2.equals("404"))
                {
                    throw new NullPointerException(" status 404 değil");

                }






            }});
    }

    @Test
    @CitrusTest
    public void DeleteStore() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "1");
                context.setVariable("petId", "12");
                context.setVariable("quantity", "0");
                context.setVariable("status", "placed");
                context.setVariable("complete", "true");
                // String name ="GetPetid";
                String name="PostStore";

                String url = "/store/order";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("store",200,url,name);

                System.out.println("******** "+name+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name+"REQ"));

                System.out.println("******** "+name+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name+"RES"));

                String res =(context.getMessageStore().getMessage(""+name+"RES")).toString();
                String response=reg(responsePatternId,res);
                String statuscode=reg(httpStatusCodePattern,res);

                jsonFormatter("[{"+response+"}]");

                int id= JsonPath.read("[{"+response+"}]","$[0]['id']");
                int petId = JsonPath.read("[{"+response+"}]","$[0]['petId']");
                String status = JsonPath.read("[{"+response+"}]","$[0]['status']");

                System.out.println("id:"+id);
                System.out.println("petId:"+petId);
                System.out.println("status:"+status);
                System.out.println("statuscode:"+statuscode);

                String name2="DeleteStore";
                String url2="/store/order/"+id+"";

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
    public void DeleteStoreHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";

                int id=0;
                String name2="DeleteStore";
                String url2="/store/order/"+id+"";

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

                Integer code = JsonPath.read("[{"+response2+"}]","$[0]['code']");
                String message = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code:"+code);
                System.out.println("message:"+message);

                System.out.println("statuscode:"+statuscode2);


                if( !statuscode2.equals("404") || code!=404 )
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }
}
