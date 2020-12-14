package ApiTest.User;

import com.consol.citrus.actions.AbstractTestAction;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Random;

import static help.regex.jsonFormatter;
import static help.regex.reg;

public class UserTest extends UserEndPointTest{

    @Test
    @CitrusTest
    public void PostUser() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "0");
                context.setVariable("username", "Test");
                context.setVariable("firstName", "Deneme");
                context.setVariable("lastName", "aaa");
                context.setVariable("email", "asdf@gmail.com");
                context.setVariable("password", "1");
                context.setVariable("phone", "12345");

                String name="PostUser";
                String url = "/user";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("user",200,url,name);

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


                if( code!=200 || message.equals("") ||!statuscode.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void PostUserHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "abc");
                context.setVariable("username", "Test");
                context.setVariable("firstName", "Deneme");
                context.setVariable("lastName", "aaa");
                context.setVariable("email", "asdf@gmail.com");
                context.setVariable("password", "1");
                context.setVariable("phone", "12345");

                String name="PostUser";
                String url = "/user";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("user",500,url,name);

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
                    throw new NullPointerException("status 500 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void PostUserCreateWithArray() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "0");
                context.setVariable("username", "Test1");
                context.setVariable("firstName", "Denemede");
                context.setVariable("lastName", "aaabb");
                context.setVariable("email", "asaadf@gmail.com");
                context.setVariable("password", "12");
                context.setVariable("phone", "123456");

                String name="PostUserCreateWithArray";
                String url = "/user/createWithArray";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("userCreateWithArray",200,url,name);

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


                if( code!=200 || !message.equals("ok") ||!statuscode.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void PostUserCreateWithArrayHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "aa");
                context.setVariable("username", "Test1");
                context.setVariable("firstName", "Denemede");
                context.setVariable("lastName", "aaabb");
                context.setVariable("email", "asaadf@gmail.com");
                context.setVariable("password", "12");
                context.setVariable("phone", "123456");

                String name="PostUserCreateWithArray";
                String url = "/user/createWithArray";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("userCreateWithArray",500,url,name);

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
    public void PostUserCreateWithList() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "0");
                context.setVariable("username", "Test1");
                context.setVariable("firstName", "Denemede");
                context.setVariable("lastName", "aaabb");
                context.setVariable("email", "asaadf@gmail.com");
                context.setVariable("password", "12");
                context.setVariable("phone", "123456");

                String name="PostUserCreateWithList";
                String url = "/user/createWithList";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("userCreateWithArray",200,url,name);

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


                if( code!=200 || !message.equals("ok") ||!statuscode.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void PostUserCreateWithListHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "aa");
                context.setVariable("username", "Test1");
                context.setVariable("firstName", "Denemede");
                context.setVariable("lastName", "aaabb");
                context.setVariable("email", "asaadf@gmail.com");
                context.setVariable("password", "12");
                context.setVariable("phone", "123456");

                String name="PostUserCreateWithList";
                String url = "/user/createWithList";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("userCreateWithArray",500,url,name);

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
    public void GetUserUsername() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "0");
                context.setVariable("username", "Test");
                context.setVariable("firstName", "Deneme");
                context.setVariable("lastName", "aaa");
                context.setVariable("email", "asdf@gmail.com");
                context.setVariable("password", "1");
                context.setVariable("phone", "12345");

                String name="PostUser";
                String url = "/user";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("user",200,url,name);

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
                String Username=context.getVariable("username");

                String name2="GetUserUsername";
                String url2="user/"+Username+"";

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

                int id= JsonPath.read("[{"+response2+"}]","$[0]['id']");
                String username = JsonPath.read("[{"+response2+"}]","$[0]['username']");

                System.out.println("id:"+id);
                System.out.println("username:"+username);
                System.out.println("statuscode2:"+statuscode2);


                if( id==0 || !username.equals(Username) ||!statuscode2.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetUserUsernameHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";

                String Username="";

                String name2="GetUserUsername";
                String url2="user/"+Username+"";

                System.out.println("****************************************** "+name2+" ***************************************************");

                getMethod(name2,url2,405);

                System.out.println("******** "+name2+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"REQ"));

                System.out.println("******** "+name2+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"RES"));

                String res2 =(context.getMessageStore().getMessage(""+name2+"RES")).toString();
                String response2=reg(responsePatternId,res2);
                String statuscode2=reg(httpStatusCodePattern,res2);

                jsonFormatter("[{"+response2+"}]");

                int code= JsonPath.read("[{"+response2+"}]","$[0]['code']");
                //String message = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code:"+code);
                //System.out.println("message:"+message);
                System.out.println("statuscode2:"+statuscode2);


                if( code==0  ||!statuscode2.equals("405"))
                {
                    throw new NullPointerException("status 405 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void PutUserUsername() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "0");
                context.setVariable("username", "Test");
                context.setVariable("firstName", "Deneme");
                context.setVariable("lastName", "aaa");
                context.setVariable("email", "asdf@gmail.com");
                context.setVariable("password", "1");
                context.setVariable("phone", "12345");

                String name="PostUser";
                String url = "/user";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("user",200,url,name);

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
                String Username=context.getVariable("username");

                String name2="PutUserUsername";
                String url2="user/"+Username+"";
                Random rand=new Random();
                int rand_int1 = rand.nextInt(1000);

                System.out.println("****************************************** "+name2+" ***************************************************");
                context.setVariable("id", "0");
                context.setVariable("username", "Test");
                context.setVariable("firstName", "Deneme"+rand_int1+"");
                context.setVariable("lastName", "aaa");
                context.setVariable("email", "asdf@gmail.com");
                context.setVariable("password", "1");
                context.setVariable("phone", "12345");

                putMethod("user",200,url2,name2);

                System.out.println("******** "+name2+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"REQ"));

                System.out.println("******** "+name2+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"RES"));

                String res2 =(context.getMessageStore().getMessage(""+name2+"RES")).toString();
                String response2=reg(responsePatternId,res2);
                String statuscode2=reg(httpStatusCodePattern,res2);

                jsonFormatter("[{"+response2+"}]");

                int code2= JsonPath.read("[{"+response2+"}]","$[0]['code']");
                String message2 = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code2:"+code2);
                System.out.println("message2:"+message2);
                System.out.println("statuscode2:"+statuscode2);


                if( code2==0 || message2.equals("") ||!statuscode2.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void PutUserUsernameHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";

                String Username="123";

                String name2="PutUserUsername";
                String url2="user/"+Username+"";
                Random rand=new Random();
                int rand_int1 = rand.nextInt(1000);

                System.out.println("****************************************** "+name2+" ***************************************************");
                context.setVariable("id", "aa");
                context.setVariable("username", "Test");
                context.setVariable("firstName", "Deneme"+rand_int1+"");
                context.setVariable("lastName", "aaa");
                context.setVariable("email", "asdf@gmail.com");
                context.setVariable("password", "1");
                context.setVariable("phone", "12345");

                putMethod("user",500,url2,name2);

                System.out.println("******** "+name2+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"REQ"));

                System.out.println("******** "+name2+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name2+"RES"));

                String res2 =(context.getMessageStore().getMessage(""+name2+"RES")).toString();
                String response2=reg(responsePatternId,res2);
                String statuscode2=reg(httpStatusCodePattern,res2);

                jsonFormatter("[{"+response2+"}]");

                int code2= JsonPath.read("[{"+response2+"}]","$[0]['code']");
                String message2 = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code2:"+code2);
                System.out.println("message2:"+message2);
                System.out.println("statuscode2:"+statuscode2);


                if( code2==0 || !message2.equals("something bad happened") ||!statuscode2.equals("500"))
                {
                    throw new NullPointerException(" status 500 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void DeleteUserUsername() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "0");
                context.setVariable("username", "Test");
                context.setVariable("firstName", "Deneme");
                context.setVariable("lastName", "aaa");
                context.setVariable("email", "asdf@gmail.com");
                context.setVariable("password", "1");
                context.setVariable("phone", "12345");

                String name="PostUser";
                String url = "/user";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("user",200,url,name);

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
                String Username=context.getVariable("username");

                String name2="DeleteUserUsername";
                String url2="user/"+Username+"";

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

                int code2= JsonPath.read("[{"+response2+"}]","$[0]['code']");
                String message2 = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code2:"+code2);
                System.out.println("message2:"+message2);
                System.out.println("statuscode2:"+statuscode2);


                if( code2==0 || message2.equals("") ||!statuscode2.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void DeleteUserUsernameHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";

                String Username="aaaabb";

                String name2="DeleteUserUsername";
                String url2="user/"+Username+"";

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

                System.out.println("statuscode2:"+statuscode2);


                if(!statuscode2.equals("404"))
                {
                    throw new NullPointerException("status 404 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetLogin() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "0");
                context.setVariable("username", "Test");
                context.setVariable("firstName", "Deneme");
                context.setVariable("lastName", "aaa");
                context.setVariable("email", "asdf@gmail.com");
                context.setVariable("password", "1");
                context.setVariable("phone", "12345");

                String name="PostUser";
                String url = "/user";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("user",200,url,name);

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
                String Username=context.getVariable("username");
                String Password=context.getVariable("password");

                String name2="GetLogin";
                String url2="user/login?username="+Username+"&password="+Password+"";

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

                int code2= JsonPath.read("[{"+response2+"}]","$[0]['code']");
                String message2 = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code2:"+code2);
                System.out.println("message2:"+message2);
                System.out.println("statuscode2:"+statuscode2);


                if( code2==0 || message2.equals("") ||!statuscode2.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetLoginHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";



                String name2="GetUserUsername";
                String url2="user/loginn?username=&password=";

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

                int code2= JsonPath.read("[{"+response2+"}]","$[0]['code']");
                String message2 = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code2:"+code2);
                System.out.println("message2:"+message2);
                System.out.println("statuscode2:"+statuscode2);


                if( code2==0 || message2.equals("") ||!statuscode2.equals("404"))
                {
                    throw new NullPointerException("status 404 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetLogout() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "0");
                context.setVariable("username", "Test");
                context.setVariable("firstName", "Deneme");
                context.setVariable("lastName", "aaa");
                context.setVariable("email", "asdf@gmail.com");
                context.setVariable("password", "1");
                context.setVariable("phone", "12345");

                String name="PostUser";
                String url = "/user";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("user",200,url,name);

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
                String Username=context.getVariable("username");
                String Password=context.getVariable("password");

                String name2="GetLogin";
                String url2="user/login?username="+Username+"&password="+Password+"";

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

                int code2= JsonPath.read("[{"+response2+"}]","$[0]['code']");
                String message2 = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code2:"+code2);
                System.out.println("message2:"+message2);
                System.out.println("statuscode2:"+statuscode2);

                String name3="GetLogout";
                String url3="user/logout";

                System.out.println("****************************************** "+name3+" ***************************************************");

                getMethod(name3,url3,200);

                System.out.println("******** "+name3+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name3+"REQ"));

                System.out.println("******** "+name3+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name3+"RES"));

                String res3 =(context.getMessageStore().getMessage(""+name3+"RES")).toString();
                String response3=reg(responsePatternId,res3);
                String statuscode3=reg(httpStatusCodePattern,res3);

                jsonFormatter("[{"+response3+"}]");

                int code3= JsonPath.read("[{"+response3+"}]","$[0]['code']");
                String message3 = JsonPath.read("[{"+response3+"}]","$[0]['message']");

                System.out.println("code3:"+code3);
                System.out.println("message3:"+message3);
                System.out.println("statuscode3:"+statuscode3);


                if( code3==0 || message3.equals("") ||!statuscode3.equals("200"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 200 değil");

                }




            }});
    }

    @Test
    @CitrusTest
    public void GetLogoutHatali() throws SQLException {
        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {


                String responsePatternId="payload: \\{(.*?)\\}\\]\\[";
                String httpStatusCodePattern="citrus_http_status_code=(.*?),";
                context.setVariable("id", "0");
                context.setVariable("username", "Test");
                context.setVariable("firstName", "Deneme");
                context.setVariable("lastName", "aaa");
                context.setVariable("email", "asdf@gmail.com");
                context.setVariable("password", "1");
                context.setVariable("phone", "12345");

                String name="PostUser";
                String url = "/user";


                System.out.println("****************************************** "+name+" ***************************************************");
                postMethod("user",200,url,name);

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
                String Username=context.getVariable("username");
                String Password=context.getVariable("password");

                String name2="GetLogin";
                String url2="user/login?username="+Username+"&password="+Password+"";

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

                int code2= JsonPath.read("[{"+response2+"}]","$[0]['code']");
                String message2 = JsonPath.read("[{"+response2+"}]","$[0]['message']");

                System.out.println("code2:"+code2);
                System.out.println("message2:"+message2);
                System.out.println("statuscode2:"+statuscode2);

                String name3="GetLogout";
                String url3="user/logoutt";

                System.out.println("****************************************** "+name3+" ***************************************************");

                getMethod(name3,url3,404);

                System.out.println("******** "+name3+" REQUEST 1.ADIM*******");
                System.out.println(context.getMessageStore().getMessage(""+name3+"REQ"));

                System.out.println("******** "+name3+" RESPONSE 1.ADIM******");
                System.out.println(context.getMessageStore().getMessage(""+name3+"RES"));

                String res3 =(context.getMessageStore().getMessage(""+name3+"RES")).toString();
                String response3=reg(responsePatternId,res3);
                String statuscode3=reg(httpStatusCodePattern,res3);

                jsonFormatter("[{"+response3+"}]");

                int code3= JsonPath.read("[{"+response3+"}]","$[0]['code']");
                String message3 = JsonPath.read("[{"+response3+"}]","$[0]['message']");

                System.out.println("code3:"+code3);
                System.out.println("message3:"+message3);
                System.out.println("statuscode3:"+statuscode3);


                if( code3==0 || message3.equals("") ||!statuscode3.equals("404"))
                {
                    throw new NullPointerException("Response  yanlış  yada status 404 değil");

                }




            }});
    }
}
