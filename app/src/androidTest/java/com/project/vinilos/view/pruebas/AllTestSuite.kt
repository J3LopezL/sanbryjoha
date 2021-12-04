package com.project.vinilos.view.unit

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    PerformersListActivityTest::class,
    CollectorListActivityTest::class
)
class AllTestSuite