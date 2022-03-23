import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import domain.Client;
import domain.EyeColor;
import domain.Partner;
import org.apache.commons.lang3.time.StopWatch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        StopWatch watch = new StopWatch();

        watch.start();
        for (int i = 1; i <= 100; i++) {
            jsoniterConvertToJson(createClientObject());
            //jsoniterConvertToObject(createClientJson());
        }
        watch.stop();

        System.out.println(watch.getTime());
        getMemoryUsage();
    }

    private static void jsoniterConvertToJson(Client client) {
        JsonStream.serialize(client);
    }

    private static void jsoniterConvertToObject(String clientJson) {
        JsonIterator.deserialize(clientJson, Client.class);
    }

    private static void getMemoryUsage() {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        //Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(memory);
    }

    private static String createClientJson() {
        return "{\n" +
                "  \"_id\": 1001,\n" +
                "  \"index\": 1,\n" +
                "  \"isActive\": true,\n" +
                "  \"balance\": 100000,\n" +
                "  \"picture\": \"picture-test\",\n" +
                "  \"age\": 35,\n" +
                "  \"eyeColor\": \"GREEN\",\n" +
                "  \"name\": \"name-test\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"company\": \"mindgeek\",\n" +
                "  \"emails\": [\n" +
                "    \"test@mindgeek.com\"\n" +
                "  ],\n" +
                "  \"address\": \"test-address\",\n" +
                "  \"about\": \"test-about-client\",\n" +
                "  \"latitude\": 5000.02,\n" +
                "  \"longitude\": 10000.02,\n" +
                "  \"tags\": [\n" +
                "    \"test-tag-1\",\n" +
                "    \"test-tag-2\",\n" +
                "    \"test-tag-3\"\n" +
                "  ],\n" +
                "  \"partners\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"partnerOne\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"partnerTwo\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"active\": true\n" +
                "}\n";
    }

    private static Client createClientObject() {
        Client client = new Client();
        client.set_id(1001);
        client.setIndex(1);
        client.setActive(true);
        client.setBalance(BigDecimal.valueOf(100000));
        client.setPicture("picture-test");
        client.setAge(35);
        client.setEyeColor(EyeColor.GREEN);
        client.setName("name-test");
        client.setGender("female");
        client.setCompany("mindgeek");
        client.setEmails(new String[]{("test@mindgeek.com")});
        client.setAddress("test-address");
        client.setAbout("test-about-client");
        client.setLongitude(10000.02);
        client.setLatitude(5000.02);
        client.setTags(Arrays.asList("test-tag-1", "test-tag-2", "test-tag-3"));
        client.setPartners(createPartnerList());

        return client;
    }

    private static List<Partner> createPartnerList() {
        Partner partnerOne = new Partner();
        partnerOne.setId(1);
        partnerOne.setName("partnerOne");

        Partner partnerTwo = new Partner();
        partnerTwo.setId(2);
        partnerTwo.setName("partnerTwo");

        List<Partner> partners = new ArrayList<>();
        partners.add(partnerOne);
        partners.add(partnerTwo);
        return partners;
    }
}
