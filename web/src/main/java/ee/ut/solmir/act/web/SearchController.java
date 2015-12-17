package ee.ut.solmir.act.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
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
    
    try {
      StopWatch stopWatch = new StopWatch();
      stopWatch.start();
      List<SimHolder> result = searchEngine.findMostSimilarMethod(code);
      if (result != null && result.size() > 0) {
        model.addAttribute("info", String.format("Found %d code fragemnt (%.2f sec)", result.size(), stopWatch.getTotalTimeSeconds()));
        model.addAttribute("result", result);
      }
      else {
        model.addAttribute("warning", "Code not found.");
      }
    }
    catch(Exception e) {
      e.printStackTrace();
      model.addAttribute("error", e.getMessage());
    }
    
    model.addAttribute("code", code);
    return "search";
  }
}
