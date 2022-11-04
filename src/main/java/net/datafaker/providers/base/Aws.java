package net.datafaker.providers.base;


/**
 * @since 1.3.0
 */
public class Aws extends AbstractProvider<BaseProviders> {

    protected Aws(BaseProviders faker) {
        super(faker);
    }

    public String region() {
        return resolve("aws.regions");
    }

    public String accountId() {
        return faker.numerify("0#########");
    }

    public String acmARN() {
        return "arn:aws:acm:" +
            region() +
            ":" +
            accountId() +
            ":certificate/" +
            faker.internet().uuid();
    }

    public String albARN() {
        return "arn:aws:elasticloadbalancing:" +
            region() +
            ":" +
            accountId() +
            ":loadbalancer/app/" +
            appName() +
            "/" +
            randHex();
    }

    public String albTargetGroupARN() {
        return "arn:aws:elasticloadbalancing:" +
            region() +
            ":" +
            accountId() +
            ":targetgroup/" +
            appName() +
            "/" +
            randHex();
    }

    public String route53ZoneId() {
        return faker.regexify("[A-Z]{21}");
    }

    public String securityGroupId() {
        return "sg-" + randHex();
    }

    public String subnetId() {
        return "subnet-" + randHex();
    }

    public String vpcId() {
        return "vpc-" + randHex();
    }

    private String appName() {
        return faker.app().name().toLowerCase().replaceAll("\\W+", "");
    }

    private String randHex() {
        return faker.random().hex(16, false);
    }
}
