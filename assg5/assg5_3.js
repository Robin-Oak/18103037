<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<!-- <pre> -->
<script>
var map = {
    "(": ")",
    "[": "]",
    "{": "}"
  }
var isvalid = (s) => {
var ours = [];
for (var i = 0; i < s.length; i++) {
    var item = s[i];
    if (map[item]) {
        ours.push(map[item]);
    } else {
    if (item !== ours.pop()) {
        return false;
    }
    }
}
return ours.length === 0;
};

s = prompt("input string", "{{(([]))}}")
document.write(isvalid(s));

</script>
<!-- </pre> -->
</body>
</html>