package demo;

import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
public class CustomConverter implements Converter<List<String>, List<MyCustomObject>> {

    @Override
    public List<MyCustomObject> convert(List<String> s) {
        List<MyCustomObject> result = new ArrayList<>();
        if (s != null) {
            for (String ss : s) {
                result.add(new MyCustomObject(ss));
            }
        }

        return result;
    }
}
