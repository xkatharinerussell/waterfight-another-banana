package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
@RestController
public class Application {

  static class Self {
    public String href;
  }

  static class Links {
    public Self self;
  }

  static class PlayerState {
    public Integer x;
    public Integer y;
    public String direction;
    public Boolean wasHit;
    public Integer score;
  }

  static class Arena {
    public List<Integer> dims;
    public Map<String, PlayerState> state;
  }

  static class ArenaUpdate {
    public Links _links;
    public Arena arena;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.initDirectFieldAccess();
  }

  @GetMapping("/")
  public String index() {
    return "Let the battle begin! Here are some cool new changes!";
  }

  @PostMapping("/**")
  public String index(@RequestBody ArenaUpdate arenaUpdate) {
    System.out.println(arenaUpdate);
    String[] commands = new String[]{"F", "R", "L", "T"};

    // Iterator<Map.Entry<String, PlayerState>> stateIt = map.entrySet().iterator();
    // while (stateIt.hasNext()) {
    //   Map.Entry<String, PlayerState> playerState = stateIt.next();
      
    // }

    Random r = new Random();
    Int i = r.nextInt(100);

    if(i <= 20) {
      return "T";
    }
    else if(i > 20 && i <= 30) {
      return "R";
    }
    else if(i > 30 && i <= 40) {
      return "L";
    }
    else {
      return "F";
    }

  }

}

