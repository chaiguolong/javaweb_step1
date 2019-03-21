<?php

  //If no search string is passed, then we can't search
  if(empty($_GET['category'])) {
    $result = "<story><url>none</url><title>No Category Sent</title></story>";
  } else {
    //Remove whitespace from beginning & end of passed search.
    $search = trim($_GET['category']);
    switch($search) {
      case "CSS" :
         $result = "<story><url>http://realtech.burningbird.net/graphics/css/opacity-returns-ie8</url>" .
                   "<title>Opacity returns to IE8</title></story>" .
                   "<story><url>http://realtech.burningbird.net/graphics/css/embedded-fonts-font-face</url>" . 
                   "<title>Embedded Fonts with Font Face</title></story>";
         break;
      case "ebooks" :
         $result = "<story><url>http://realtech.burningbird.net/web/ebooks/kindle-clipping-limits</url>" .
                   "<title>Kindle Clipping Limits</title></story>" .
                   "<story><url>http://realtech.burningbird.net/web/ebooks/kindle-and-book-freebies</url>" . 
                   "<title>Kindle and Book Freebies</title></story>";
         break;
      case "video" :
         $result = "<story><url>http://secretofsignals.burningbird.net/science/how-things-work/video-online-crap-shoot</url>" .
                   "<title>The Video Online Crap Shoot</title></story>" .
                   "<story><url>http://secretofsignals.burningbird.net/toys-and-technologies/gadgets/review-flip-ultra-camcorder</url>" .
                   "<title>Review of the Flip Ultra Camcorder</title></story>" .
                   "<story><url>http://secretofsignals.burningbird.net/reviews/movies-disc/gojira</url>" . 
                   "<title>Gojira</title></story>" .
                   "<story><url>http://secretofsignals.burningbird.net/reviews/movies-disc/its-raging-squid</url>" . 
                   "<title>It's a Raging Squid</title></story>";
         break;
      case "missouri" :
         $result = "<story><url>http://missourigreen.burningbird.net/times-past/missouri/tyson-valley-lone-elk-and-bomb</url>" .
         "<title>Tyson Valley, a Lone Elk, and a Bomb</title></story>";
         break;
      default :
         $result = "<story><url>none</url><title>No Stories Found</title></story>";
         break;
      }
  }

  $result ='<?xml version="1.0" encoding="UTF-8" ?>' .
              "<stories>" . $result . "</stories>";
  header("Content-Type: text/xml; charset=utf-8");
  echo $result;
?>
