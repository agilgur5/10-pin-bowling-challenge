package bowling

object Bowler {
  /* accepts a valid sequence of throws and returns the total */
  def bowl(str: String): Int = {
    var total = 0
    var currFrame = 1
    var numTries = 2
    var bonusTries = 0
    var prev = ""
    var prevNum = 0
    var prevTwo = ""

    for (char <- str) {
      val charStr = char.toString // convert char to string
      var current = 0 // current will store integer value of char

      // decrement bonus tries
      if (bonusTries > 0) {
        bonusTries -= 1
      }

      // strike
      if (charStr == "X") {
        current = 10
        // only on first throw / strike of 10th frame do you get bonus throws
        if (currFrame == 10 && numTries == 2) {
          bonusTries = 2
        }
        numTries = 0 // no more tries if strike
      // spare
      } else if (charStr == "/") {
        current = 10 - prevNum
        // only on second throw / spare of 10th frame do you get a bonus throw
        if (currFrame == 10 && numTries == 1) {
          bonusTries = 1
        }
        numTries = 0 // no  more tries if spare
      // still pins left
      } else {
        // missed
        if (charStr == "-") {
          current = 0
        } else {
          current = charStr.toInt
        }
        numTries -= 1
      }
      total += current

      // add bonus during spare or strike
      if (prev == "/" || prev == "X") {
        total += current
      }
      // note: condition below is not mutually exclusive with above
      if (prevTwo == "X") {
        total += current
      }

      prevTwo = prev
      // don't record previous throw if a 10th frame spare / strike
      if (currFrame == 10 && (charStr == "/" || charStr == "X" || prev == "")) {
        prev = ""
        prevNum = 0
      } else {
        prev = charStr
        prevNum = current
      }

      // increment frame if no more tries and reset tries
      if (numTries == 0 && bonusTries == 0) {
        currFrame += 1
        numTries = 2
      }
    }

    return total
  }
}

