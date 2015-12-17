package ee.ut.solmir.act.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ee.ut.solmir.act.SearchEngine;
import ee.ut.solmir.act.SearchEngine.SimHolder;

@Controller
public class SearchController {
  
  private final SearchEngine searchEngine = new SearchEngine();
  
  @RequestMapping({"/", "/search"})
  public String search(@RequestParam(required=false)String code, Model model) {
    if (code == null || code.isEmpty()) {
      model.addAttribute("code", "// enter your code snippet here");
      return "search";
    }
    
    List<SimHolder> result = searchEngine.findMostSimilarMethod(code);
    
    model.addAttribute("result", result);
    model.addAttribute("code", code);
    return "search";
  }
}
