<?php

//If no search string is passed, then we can't search
if(empty($_REQUEST['one']) || empty($_REQUEST['two'])) {
  echo "No Data Sent";
} else {
   $result = $_REQUEST['one'] . ' ' . $_REQUEST['two'];
   echo $result;
}
?>
