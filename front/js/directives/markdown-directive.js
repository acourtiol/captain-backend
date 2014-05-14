app.directive('markdown', function () {
    var converter = new Showdown.converter();
    return {
        restrict: 'A',
        link: function (scope, element, attrs, ctrl) {
            scope.$watch(attrs.markdown, function (newValue) {
                element.html(converter.makeHtml(newValue));
            });
        }
    };

});
