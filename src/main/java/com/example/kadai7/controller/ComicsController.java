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
            return Map.of("ワンピース", "103巻");
        } else if (comic.equals("チェンソーマン")) {
            return Map.of("チェンソーマン", "11巻");
        }
        return null;
    }

    @PostMapping("/comics")
    public ResponseEntity<String> postComics(@RequestBody @Validated ComicForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/comics/id") // id部分は実際に登録された際に発⾏したidを設定する
                .build()
                .toUri();
        return ResponseEntity.created(url).body(form.getName() + ":" + form.getNumber_comic() + "巻を登録しました。");
    }

    @PatchMapping("/comics")
    public ResponseEntity<String> patchComics(@RequestBody @Validated ComicForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/comics/id") // id部分は実際に更新された際に発⾏したidを設定する
                .build()
                .toUri();
        return ResponseEntity.created(url).body(form.getName() + ":" + form.getNumber_comic() + "巻を更新しました。");
    }

    @DeleteMapping("/comics")
    public ResponseEntity<String> deleteComics(@RequestBody @Validated ComicForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/comics/id") // id部分は実際に削除された際に発⾏したidを設定する
                .build()
                .toUri();
        return ResponseEntity.created(url).body(form.getName() + ":" + form.getNumber_comic() + "巻を削除しました。");
    }
}
