package com.example.jbdl.demoredis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    // prefix + id + delimiter + name

    private static final String PERSON_REDIS_STRING_KEY_PREFIX = "per::";
    private static final String PERSON_REDIS_LIST_KEY = "per_list";
    private static final String PERSON_REDIS_HASH_KEY_PREFIX = "per_hash::";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    // -------------- Storing value as a string -------------

    @GetMapping("/value")
    public Person getValue(@RequestParam("id") int personId){
        return (Person) redisTemplate.opsForValue()
                .get(getPersonKey(personId));
    }

    @PostMapping("/value")
    public void saveValue(@Valid @RequestBody Person person,
                          @RequestParam(value = "expire", required = false) Integer expiry){


        if(expiry == null){
            redisTemplate.opsForValue().set(getPersonKey(person.getId()), person);
        }else{
            redisTemplate.opsForValue().set(getPersonKey(person.getId()), person, expiry, TimeUnit.SECONDS);
        }
    }

    private String getPersonKey(Integer personId){
        return PERSON_REDIS_STRING_KEY_PREFIX + personId;
    }


    // --------------- Storing value as a list of string ---------------------------

    @PostMapping("/add/left")
    public long addPersonToLeft(@Valid @RequestBody Person person){
        return redisTemplate.opsForList()
                .leftPush(PERSON_REDIS_LIST_KEY, person);
    }

    @PostMapping("/add/right")
    public long addPersonToRight(@Valid @RequestBody Person person){
        return redisTemplate.opsForList()
                .rightPush(PERSON_REDIS_LIST_KEY, person);
    }

    @DeleteMapping("/remove/right")
    public List<Person> removePersonFromRight(@RequestParam(value = "count", required = false, defaultValue = "1") Integer count){
        List<Object> result = redisTemplate.opsForList()
                .rightPop(PERSON_REDIS_LIST_KEY, count);

        return result.stream()
                .map(obj -> (Person) obj)
                .collect(Collectors.toList());
    }


    @DeleteMapping("/remove/left")
    public List<Person> removePersonFromLeft(@RequestParam(value = "count", required = false, defaultValue = "1") Integer count){
        List<Object> result = redisTemplate.opsForList()
                .leftPop(PERSON_REDIS_LIST_KEY, count);

        return result.stream()
                .map(obj -> (Person) obj)
                .collect(Collectors.toList());
    }

    @GetMapping("/person")
    public List<Person> getPeople(@RequestParam(value = "start", required = false, defaultValue = "0") int start,
                                  @RequestParam(value = "end", required = false, defaultValue = "-1") int end){

        List<Object> res = redisTemplate.opsForList().range(PERSON_REDIS_LIST_KEY, start, end);

        return res.stream().map(Person.class::cast)
                .collect(Collectors.toList());
    }


    // ---------------------- Hash Operations ------------------------------------

    @PostMapping("/hash/save")
    public void hset(@Valid @RequestBody Person person){

        Map map = objectMapper.convertValue(person, Map.class);
        redisTemplate.opsForHash().putAll(getHashKey(person.getId()), map);
    }

    @GetMapping("/hash/person")
    public Person getPerson(@RequestParam("id") int id){

        Map result = redisTemplate.opsForHash().entries(getHashKey(id));
        return objectMapper.convertValue(result, Person.class);
    }

    private String getHashKey(int personId){
        return PERSON_REDIS_HASH_KEY_PREFIX + personId;
    }


}
