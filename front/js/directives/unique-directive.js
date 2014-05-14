app.directive('fnUnique', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        scope: {
            search: '&fnUnique'
        },
        link: function (scope, element, attrs, ctrl) {
            scope.$parent.$watch(attrs.ngModel, function (value) {
                scope.search(function (result) {
                    ctrl.$setValidity('fnUnique', result);
                });
            });
        }
    };
});