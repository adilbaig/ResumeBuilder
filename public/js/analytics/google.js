define(['module', 'google-analytics'], function(module, ga) {

    var config = module.config();

    ga('create', config.google.accountNo, config.google.domainName);
    ga('send', 'pageview');

});
