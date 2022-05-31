package repository

import com.vladzbuker.domain.repository.TestRepo

class TestRepoImpl: TestRepo {

    override fun getSomeData(): String {
        return "Success"
    }

}