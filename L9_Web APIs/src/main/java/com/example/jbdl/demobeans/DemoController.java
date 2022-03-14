package com.example.jbdl.demobeans;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/api/v1")
//@Controller // This is just to make this controller visible to the dispatcher servlet
//@ResponseBody
@RestController
public class DemoController {

    // Java - Json --> ResponseBody
    // Json - Java --> RequestBody

    // RestController = Controller + ResponseBody

//    @Autowired
    // New keyword here resembles the prototype scope
//    @Autowired
//    @Qualifier("bean1")
//    RestTemplate restTemplate;

    @Autowired
    DemoConfig demoConfig;

    Child child;

    @Value("${jbdl.batch.number}")
    int batchNumber;

    int lectureNumber;

    // Constructor injection
    @Autowired
    public DemoController(DemoConfig demoConfig,
                          @Value("${jbdl.lecture.number}") int number) {
        this.demoConfig = demoConfig;
        System.out.println("The number of lecture for jbdl batch is " + number);
        System.out.println("The batch number of jbdl is " + this.batchNumber);
        this.lectureNumber = number;
    }

//    @Autowired
//    public DemoController(){
//        System.out.println("In democontroller constructor " + this.demoConfig);
//    }

    public DemoController(Child child){
        this.child = child;
    }

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/fetch_config")
    public List<Integer> fetchConfig(){
        return Arrays.asList(this.batchNumber, this.lectureNumber);
    }

    @GetMapping("/greet")
    public String greetPerson(@RequestParam("name") String s){
        return "Hello " +  s + "!!";
    }

    @GetMapping("/bye")       // --> /api/v1/bye
    public String byePerson(@RequestParam("name") String p){
        return "Bye " + p + "!!!";
    }

    @GetMapping("/person")
    public Person getPerson(@RequestParam("id") int id, @RequestParam("name") String name){
        return new Person();
    }

    @GetMapping("/save")
    public void savePerson(@RequestParam("name") String name){
        System.out.println("Got request to save person " + name);
    }

    /**
     * Input - id (required = true), length , breadth (required = false) 200 * 200
     * Output - image to show
     **/


    // 1, 10, 100, 1000

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@RequestParam("id") int id,
                         @RequestParam(value = "l", required = false, defaultValue = "200") int l,
                         @RequestParam(value = "b", required = false, defaultValue = "300") int b){

        String url = "https://picsum.photos/id/" + id + "/" + l + "/" + b; // StringBuilder

        RestTemplate restTemplate1 = new RestTemplate(); //
        RestTemplate restTemplate = demoConfig.getTemplate();
        logger.info("restTemplate {}", restTemplate);

        byte[] response = restTemplate.getForObject(url, byte[].class);

        return response;
    }

    // Every servlet container / embedded server has httpservletrequest interface
    @PostMapping("/file/parse")
    public List<Person> parseBulkFile(HttpServletRequest httpServletRequest) throws ServletException, IOException {

        List<Person> personList = new ArrayList<>();
        Part p1 = httpServletRequest.getPart("part1");

        InputStream inputStream = p1.getInputStream();


        CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator("\n").withDelimiter(';');
        CSVParser csvParser = new CSVParser(new InputStreamReader(inputStream), csvFormat);

        List<CSVRecord> records = csvParser.getRecords();

        // List<Person> result = new CsvToBeanBuilder(new InputStreamReader(inputStream)).withType(Person.class).build().parse();

        for(CSVRecord csvRecord : records){

            if(csvRecord.getRecordNumber() == 1){
                continue;
            }

            int id = Integer.parseInt(csvRecord.get(0));
            String firstName = csvRecord.get(1);
            String lastName = csvRecord.get(2);
            int age = Integer.parseInt(csvRecord.get(3));
            String dob = csvRecord.get(4);

            personList.add(new Person(id, firstName, lastName, age, dob));
        }


        // Parse the file, extract the contents
        // Create person objects and return the list of those objects

        return personList;
    }

    // Ques : We will take a csv file in the input, we will parse the csv file using some parser and then print the result
}

// diff b/w controller and restcontroller
