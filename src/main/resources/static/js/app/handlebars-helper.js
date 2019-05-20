Handlebars.registerHelper('each_upto', function(ary) {
    var result = [ ];
    for(var i = 0; i < 5; i++)
        result.push(ary.get(i));
    return result.join('');
});

Handlebars.registerHelper('isVowel', function(options) {
    var regexp = /^[aeiou]/;
    if (regexp.test(this.name)) {
        return options.fn(this);
    } else {
        return options.inverse(this);
    }
});