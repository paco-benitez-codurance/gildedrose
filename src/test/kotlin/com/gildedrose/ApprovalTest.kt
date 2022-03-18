package com.gildedrose

import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

import org.approvaltests.Approvals

internal class ApprovalTest {

    @Test
    fun approvalTestForOneDay() {
        val res = fakeOutput { main(emptyArray()) }
        Approvals.verify(res)
    }

    @Test
    fun approvalTestForTenDays() {
        val res = fakeOutput { main(arrayOf("10")) }
        Approvals.verify(res)
    }


    companion object {
        private fun fakeOutput(func: () -> Unit): String {
            val os = ByteArrayOutputStream()
            val fakeOut = PrintStream(os)
            val origOutput = System.out
            val res: String
            try {
                System.setOut(fakeOut)
                func()
                fakeOut.flush()
                res = String(os.toByteArray())
            } finally {
                System.setOut(origOutput)
            }
            return res
        }
    }
}