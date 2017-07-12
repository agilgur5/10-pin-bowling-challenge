package bowling

import org.scalatest.FunSpec

class BowlerSpec extends FunSpec {
  describe("A bowling sequence") {
    describe("when valid") {
      it("should calculate regular throws and misses correctly") {
        assert(Bowler.bowl("9-9-9-9-9-9-9-9-9-9-") == 90)
      }
      it("should calculate strikes correctly") {
        assert(Bowler.bowl("XXXXXXXXXXXX") == 300)
      }
      it("should calculate spares correctly") {
        assert(Bowler.bowl("5/5/5/5/5/5/5/5/5/5/5") == 150)
      }
      it("should calculate mixed spares and strikes correctly") {
        assert(Bowler.bowl("5/XX5/5/5/5/5/5/5/X") == 175)
      }
    }
  }
}
