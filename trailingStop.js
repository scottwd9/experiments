function trailingStop(price, stop_percent) {
  var stop = price - price * stop_percent/100
  return {
    stop: stop,
    limit: stop - 0.25
  }
}
