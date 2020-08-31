package org.example;

import com.sun.corba.se.spi.ior.Identifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


//    String pathCaseOwnerId = getOwnerId("pathDefinedCaseSystemId");
    String pathCaseOwnerId = getOwnerId(null);

//        System.out.println(!pathCaseOwnerId.isEmpty() && getOwnerId(null).equals(pathCaseOwnerId));
        System.out.println(!pathCaseOwnerId.isEmpty() && getOwnerId("item").equals(pathCaseOwnerId));

        System.out.println("item---->" + getOwnerId("item") + "---->" +  getOwnerId("item").isEmpty());
        System.out.println("null---->" + getOwnerId(null) + "---->" + getOwnerId(null).isEmpty());
        System.out.println("============================================================");
        List<String> casesLimitExceeded = new ArrayList<>();
        List<Integer> integers = Stream.of(1,2,3,4,5,6).collect(Collectors.toList());
        System.out.println(integers);
        integers.stream().map(App::getOptional).filter(Optional::isPresent).forEach(i->casesLimitExceeded.add(i.get()));
        System.out.println(casesLimitExceeded);



        System.out.println("============================================================");
        List<String> casesLimitExceeded_2 = new ArrayList<>();

        integers.forEach(s-> {
            getOptional(s).ifPresent(casesLimitExceeded_2::add);
        });
        System.out.println(casesLimitExceeded_2);
    }


    private static Optional<String> getOptional(int integer) {
        if (integer % 2 != 0) {
            return Optional.of(String.valueOf(integer));
        }
        return Optional.empty();
    }


    private static String getOwnerId(String item){
        return Optional.ofNullable(item).map(s -> s).orElse("");
    }

}
