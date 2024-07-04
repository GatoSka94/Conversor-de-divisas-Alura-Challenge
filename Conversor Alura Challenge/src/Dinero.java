import java.util.ArrayList;
import java.util.List;

public record Dinero(String base_code,

                     String target_code,

                     double conversion_result

                     ){


    @Override
    public String toString() {
        return ""+conversion_result;
    }
}
