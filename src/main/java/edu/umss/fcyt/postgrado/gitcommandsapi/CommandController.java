package edu.umss.fcyt.postgrado.gitcommandsapi;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/commands")
public class CommandController {
    private final CommandRepository commandRepository;

    @GetMapping("/")
    public List<Command> getAllCommands() {
        return commandRepository.findAll();
    }

    @GetMapping("/{id}")
    public Command getCommandById(@PathVariable Long id) {
        return commandRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Command addCommand(@RequestBody Command command) {
        return commandRepository.save(command);
    }

    @PutMapping("/{id}")
    public Command updateCommand(@PathVariable Long id, @RequestBody Command command) {
        command.setId(id);
        return commandRepository.save(command);
    }

    @DeleteMapping("/{id}")
    public void deleteCommand(@PathVariable Long id) {
        commandRepository.deleteById(id);
    }

    @GetMapping("/search")
    public List<Command> searchCommands(@RequestParam(name = "name") String name) {
        return commandRepository.findByNameContaining(name);
    }
}
