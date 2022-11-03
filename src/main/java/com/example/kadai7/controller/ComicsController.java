package com.example.kadai7.controller;

import com.example.kadai7.form.ComicForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
public class ComicsController {

    @GetMapping("/comics")
    public Map<String, String> getComics(@RequestParam String comic) {
        if (comic.equals("ワンピース")) {
            return Map.of("name", "ワンピース", "latestVolume", "103巻");
        } else if (comic.equals("チェンソーマン")) {
            return Map.of("name", "チェンソーマン", "latestVolume", "11巻");
        }
        return null;
    }

    @PostMapping("/comics")
    public ResponseEntity<Map<String, String>> postComics(@RequestBody @Validated ComicForm form, UriComponentsBuilder uriBuilder) {
        URI url = uriBuilder.path("/comics/id").
                build().
                toUri();
        return ResponseEntity.created(url).body(Map.of("message", form.getName() + ":" + form.getLatestVolume() + "巻を登録しました。"));
    }

    @PatchMapping("/comics")
    public ResponseEntity<Map<String, String>> patchComics(@RequestBody @Validated ComicForm form) {
        return ResponseEntity.ok(Map.of("message", form.getName() + ":" + form.getLatestVolume() + "巻を更新しました。"));
    }

    @DeleteMapping("/comics")
    public ResponseEntity<Map<String, String>> deleteComics(@RequestBody @Validated ComicForm form) {
        return ResponseEntity.ok(Map.of("message", form.getName() + ":" + form.getLatestVolume() + "巻を削除しました。"));
    }
}
