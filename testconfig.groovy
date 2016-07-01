

conf {
    //defaults
    glue = "com.netaporter.cucumber.steps " +
            "com.netaporter.test.utils.cucumber.glue"
    //don't forget to leave a space between values when concatenating!!!!
    path = "classpath:com/netaporter/cucumber/features"
}
// Environment names should be lowercase, field values concatenated
environments {
    sanity{
        conf {
            tags = "@Sanity "+
                   "~@known-failure"
        }
    }


    scdesktopall{
        conf{
            path="classpath:com/netaporter/cucumber/features/sc"
            tags = "@desktop " +
                    "~@known-failure"
        }
    }

    sciphoneall{
        conf{
            path="classpath:com/netaporter/cucumber/features/sc"
            tags =  "@mobile " +
                    "~@known-failure"
        }
    }
    scdesktopall{
        conf{
            path="classpath:com/netaporter/cucumber/features/sc"
            tags =  "@desktop " +
                    "~@known-failure"
        }
    }

}