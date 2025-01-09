package day57;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

public class MVC {
}
//-----MVC1-----//
class MVC1ViewController{ }
class MVC1Dao{}

//-----MVC2-----//
class MVC2View{ }
class MVC2Controller{ }
class MVC2Dao{ }

//-----MVC2 3티어-----//
// View : resource 안에 (html,css,js) 존재
class MVC2tier3Controller{ }
class MVC2tier3Service{ }
class MVC2tier3Dao{ }

//-----Spring MVC2-3tier-----//
@RestController
class MVCController{ }
@Service
class MVCService{ }
@Component
class MVCDao{ }